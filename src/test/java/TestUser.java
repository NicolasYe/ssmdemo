import com.sun.deploy.util.StringUtils;
import com.yexu.ssmdemo.mapper.UserMapper;
import com.yexu.ssmdemo.pojo.Device;
import com.yexu.ssmdemo.pojo.Experience;
import com.yexu.ssmdemo.pojo.StudentClass;
import com.yexu.ssmdemo.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestUser {
    @Test
    public void testSelectUserByUsername() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        User user = um.selectUserByUsername("15861891135");
//        System.out.println(user.toString());
        System.out.println(user.getShcool());
    }

    @Test
    public void testSelectDeviceByUsername() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        List<Device> devices = um.selectDeviceByUsername("15861891135");
        for (Device device : devices) {
            System.out.println(device.toString());
        }

    }

    @Test
    public void testSelectUserByDeviceId() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        User user = um.selectUserByDeviceId("3033313830373031323437");
        System.out.println(user.toString());
    }

    @Test
    public void testSelectDeviceByDeviceId() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        Device device = um.selectDeviceByDeviceId("3033313830373031323437");
        System.out.println(device == null);
    }

    @Test
    public void testUpdataRecordById() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        Experience ex = new Experience();
        ex.setId(16069);
        ex.setLeft_degree(new Double(100));
//        System.out.println(ex.getLeft_degree());
//        System.out.println(ex.getRight_vision());
        um.updateRecord(ex);
    }

    @Test
    public void testSelectRecordById() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        Experience ep = um.selectRecordById(16069);
        System.out.println(ep.toString());
    }

    @Test
    public void test1() {

        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();

        stringMultiValueMap.add("早班 9:00-11:00", "周一");
        stringMultiValueMap.add("早班 9:00-11:00", "周二");
        stringMultiValueMap.add("中班 13:00-16:00", "周三");
        stringMultiValueMap.add("早班 9:00-11:00", "周四");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周五");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周六");
        stringMultiValueMap.add("中班 13:00-16:00", "周日");
        //打印所有值
        System.out.println(stringMultiValueMap.get("早班 9:00-11:00"));
//        Set<String> keySet = stringMultiValueMap.keySet();
//        for (String key : keySet) {
//            List<String> values = stringMultiValueMap.get(key);
//            System.out.println(StringUtils.join(values, " ") + ":" + key);
//        }
    }

    @Test
    public void testSelectUserAndDevice() {
        Map<String, List<String>> map = new HashMap<>();
//        Map<String,List<String>> userDeviceMap=new HashMap<String,List<String>>();
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        List<User> users = um.selectUserAndDevice();
//        for(User user:users){
//            System.out.println(user.getUsername()+"->"+user.getDeviceAndUser().getDevice().getDevice_id());
//        }
//        List<String> deviceIds=new ArrayList<String>();
        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();
//        Map<String,List<String>> userDeviceMap=new HashMap<String,List<String>>();
        for (User user : users) {
            stringMultiValueMap.add(user.getUsername(), user.getDeviceAndUser().getDevice().getDevice_id());
        }
        Set<String> keySet = stringMultiValueMap.keySet();
        for (String key : keySet) {
            System.out.println(key);
//            List<String> values = stringMultiValueMap.get(key);
//            System.out.println(StringUtils.join(values, " ") + ":" + key);
        }
        System.out.println(keySet.size());
//        deviceIds.add(users.get(0).getDeviceAndUser().getDevice().getDevice_id());
//        userDeviceMap.put(users.get(0).getUsername(),deviceIds);
//        for(int i=1;i<users.size();i++){
//            int j=i;
//            int k=i;
//            if(users.get(j).getUsername().equals(users.get(--j).getUsername())){
//                if(!(users.get(k).getDeviceAndUser().getDevice().getDevice_id().equals(users.get(--k).getDeviceAndUser().getDevice().getDevice_id()))){
//                    deviceIds.add(users.get(k).getDeviceAndUser().getDevice().getDevice_id());
//                }
//            }
//        }

    }

    @Test
    public void testSelectStudent() {
        ApplicationContext application = new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um = application.getBean("userMapper", UserMapper.class);
        StudentClass studentClass = um.selectStudent(1);
        System.out.println(studentClass.toString());
    }

}
