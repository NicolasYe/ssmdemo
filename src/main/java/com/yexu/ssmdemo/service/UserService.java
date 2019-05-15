package com.yexu.ssmdemo.service;

import com.yexu.ssmdemo.mapper.UserMapper;
import com.yexu.ssmdemo.pojo.*;
import com.yexu.ssmdemo.service.exceptions.UserException;
import com.yexu.ssmdemo.service.interfaces.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserService implements IUserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public static void conver(Device device) {
        if (device.getDevice_id().startsWith("ff5408000b")) {
            String sub = device.getDevice_id().substring(10, 33);
            device.setDevice_id(convertHexToString(sub));
//                System.out.println(device.getDevice_id());
        } else if (device.getDevice_id().startsWith("30333")) {
            device.setDevice_id(convertHexToString(device.getDevice_id()));
        }
    }

    public static String convertStringToHex(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }

    public static String convertHexToString(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
//49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {
//grab the hex in pairs
            String output = hex.substring(i, (i + 2));
//convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
//convert the decimal to character
            sb.append((char) decimal);
            temp.append(decimal);
        }
//        System.out.println("Decimal : " + temp.toString());
        return sb.toString();
    }

    @Override
    public User checkLogin(String username, String password) {
//        User user=userMapper.selectUserByUsername(username);
//        if(user==null){
//            throw new UserException("用户名不存在");
//        }else{
//            return user;
//        }
        User user = userMapper.loginAction(username, password);
        if (user == null) {
            throw new UserException("用户名和密码不匹配");
        } else {
            return user;
        }

    }

    @Override
    public DeviceUser searchByUsername(String username) {
//        User user = null;
        try {
            User user = userMapper.selectUserByUsername(username);
            List<Device> devices = userMapper.selectDeviceByUsername(username);
            for (Device device : devices) {
                conver(device);
            }
            DeviceUser du = new DeviceUser(user, devices);
            return du;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public DeviceUser searchByBarCode(String barCode) {
        String deviceId = convertStringToHex(barCode);
        System.out.println(deviceId);
        Device device = userMapper.selectDeviceByDeviceId(deviceId);
        if (device != null) {
            System.out.println(device.toString());
            conver(device);
            List<Device> devices = new ArrayList<>();
            devices.add(device);
            User user = userMapper.selectUserByDeviceId(deviceId);
            System.out.println(user.toString());
            DeviceUser du = new DeviceUser(user, devices);
            return du;
        } else {
            throw new UserException("该设备为找到或未被绑定任何账号");
        }

    }

    @Override
    public Boolean ubindByUsernameOrBarCode(String barCode, String username) {
        boolean flag = false;
        String deviceId = convertStringToHex(barCode);
        System.out.println(deviceId);
        User user1 = userMapper.selectUserByDeviceId(deviceId);
        User user2 = userMapper.selectUserByUsername(username);
        if (user1.getId().intValue() == user2.getId().intValue()) {
            flag = userMapper.deleteDeviceByDeviceId(deviceId);
        }
        System.out.println(flag);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(String username) {
        boolean flag = userMapper.deleteUserByUsername(username);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找体验记录
     *
     * @param username
     * @return
     */
    @Override
    public Records searchRecord(String username) {
        List<Experience> experiences = userMapper.selectRecordByUsername(username);
        Records records = new Records(experiences);
        return records;
    }

    @Override
    public void updateRecord(Experience experience) {
        try {
            Experience ep = userMapper.selectRecordById(experience.getId());
            if (Double.doubleToLongBits(ep.getLeft_vision()) == Double.doubleToLongBits(experience.getLeft_vision()))
                experience.setLeft_vision(null);
            if (Double.doubleToLongBits(ep.getRight_vision()) == Double.doubleToLongBits(experience.getRight_vision()))
                experience.setRight_vision(null);
            if (Double.doubleToLongBits(ep.getVision()) == Double.doubleToLongBits(experience.getVision()))
                experience.setVision(null);
            if (Double.doubleToLongBits(ep.getLeft_degree()) == Double.doubleToLongBits(experience.getLeft_degree()))
                experience.setLeft_degree(null);
            if (Double.doubleToLongBits(ep.getRight_degree()) == Double.doubleToLongBits(experience.getRight_degree()))
                experience.setRight_degree(null);
            if (experience.getLeft_vision() == null && experience.getRight_vision() == null && experience.getVision() == null &&
                    experience.getLeft_degree() == null && experience.getRight_degree() == null) {
                throw new UserException("无更新内容");
            }
//        System.out.println(experience.toString());
            userMapper.updateRecord(experience);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException(e.getMessage());
        }

    }

    @Override
    public void deleteRecord(String id) {
        try {
            userMapper.deleteRecord(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserException(e.getMessage());
        }

    }

    @Override
    public void deleteAllRecord(String userId) {
        try {
            userMapper.deleteAllRecord(Integer.parseInt(userId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public MultiValueMap<String, String> selectAllUserAndDevice(String city) {
        List<User> users=userMapper.selectUserAndDevice();
        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();
        for (User user : users) {
            stringMultiValueMap.add(user.getUsername(), user.getDeviceAndUser().getDevice().getDevice_id());
        }
//        Set<String> keySet = stringMultiValueMap.keySet();
//        for (String key : keySet) {
//            System.out.println(key);
//            List<String> values = stringMultiValueMap.get(key);
//            System.out.println(StringUtils.join(values, " ") + ":" + key);
//        }

        return stringMultiValueMap;
    }

}
