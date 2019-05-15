package com.yexu.ssmdemo.controller;

import com.yexu.ssmdemo.pojo.*;
import com.yexu.ssmdemo.service.interfaces.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Set;

@Controller
public class UserController {
    @Resource
    private IUserService iUserService;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public ResponseResult<User> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username + "----" + password);
        User user = null;
        try {
            user = iUserService.checkLogin(username, password);
//            System.out.println(user.toString());
            return new ResponseResult<User>(1, user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(0, e.getMessage());
        }
    }

    /**
     * 通过手机号查找绑定关系
     *
     * @param username
     * @return
     */
    @RequestMapping("searchUsername")
    @ResponseBody
    public ResponseResult<DeviceUser> searchUsername(@RequestParam("username") String username) {
//        System.out.println(username);
        DeviceUser du = null;
        try {
            du = iUserService.searchByUsername(username);
            return new ResponseResult<DeviceUser>(1, du);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(0, e.getMessage());
        }

    }

    /**
     * 通过设备号查找绑定关系
     *
     * @param barCode
     * @return
     */
    @RequestMapping("searchBar")
    @ResponseBody
    public ResponseResult<DeviceUser> searchBar(@RequestParam("barCode") String barCode) {
        System.out.println(barCode);
        DeviceUser du = null;
        try {
            du = iUserService.searchByBarCode(barCode);
            return new ResponseResult<DeviceUser>(1, du);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseResult<>(0, e.getMessage());
        }

    }

    /**
     * 解绑
     *
     * @param username
     * @param barCode
     * @return
     */
    @RequestMapping("ubind")
    public String ubind(@RequestParam("username") String username, @RequestParam("barCode") String barCode) {
//        System.out.println(username);
//        System.out.println(barCode);
        Boolean flag = iUserService.ubindByUsernameOrBarCode(barCode, username);
//        System.out.println(flag);
        return "forward:/searchUsername.do";

//        return null;
    }

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    @RequestMapping("deleteuser")
    @ResponseBody
    public ResponseResult<Void> delete(@RequestParam("username") String username) {
        System.out.println(username);
        boolean flag = iUserService.deleteUser(username);
        if (flag) {
            return new ResponseResult<>(1, "ok");
        } else {
            return new ResponseResult<>(0, "notok");
        }
    }

    /**
     * 体验记录
     * @param username
     * @return
     */
    @RequestMapping("searchExperience")
    @ResponseBody
    public ResponseResult<Records> searchExperience(@RequestParam("username") String username) {
        Records records = iUserService.searchRecord(username);
        return new ResponseResult<>(1, records);
    }

    /**
     * 更改体验记录
     * @param id
     * @param leftVision
     * @param rightVision
     * @param vision
     * @param leftDegree
     * @param rightDegree
     * @return
     */
    @RequestMapping("updateRecord")
    @ResponseBody
    public ResponseResult<Void> updateRecord(@RequestParam("id") String id,
                                             @RequestParam("leftVision") String leftVision,
                                             @RequestParam("rightVision") String rightVision,
                                             @RequestParam("vision") String vision,
                                             @RequestParam("leftDegree") String leftDegree,
                                             @RequestParam("rightDegree") String rightDegree) {

//        System.out.println(id);
//        System.out.println(leftVision);
//        System.out.println(rightVision);
//        System.out.println(vision);
//        System.out.println(leftDegree);
//        System.out.println(rightDegree);
        Experience ep=new Experience();
        ep.setId(Integer.parseInt(id));
        ep.setLeft_vision(Double.parseDouble(leftVision));
        ep.setRight_vision(Double.parseDouble(rightVision));
        ep.setVision(Double.parseDouble(vision));
        ep.setLeft_degree(Double.parseDouble(leftDegree));
        ep.setRight_degree(Double.parseDouble(rightDegree));
        try {
            iUserService.updateRecord(ep);
            return new ResponseResult<>(1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(0,e.getMessage());
        }
    }

    @RequestMapping("deleteRecord")
    @ResponseBody
    public ResponseResult<Void> deleteRecord(@Param("id") String id){
        try {
            iUserService.deleteRecord(id);
            return new ResponseResult<>(1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(0,e.getMessage());
        }
    }
    @RequestMapping("deleteAllRecord")
    @ResponseBody
    public ResponseResult<Void> deleteAllRecord(@Param("userId") String userId){
        try {
            iUserService.deleteAllRecord(userId);
            return new ResponseResult<>(1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(0,e.getMessage());
        }
    }

    @RequestMapping("getAllUserCorrespondDeviceBycity")
    @ResponseBody
    public ResponseResult<MultiValueMap<String, String>> getAllUserCorrespondDevice(@Param("city") String city){
        System.out.println(city);
        MultiValueMap<String, String> resultMap= iUserService.selectAllUserAndDevice(city);

        return new ResponseResult<>(0,resultMap);
    }
}
