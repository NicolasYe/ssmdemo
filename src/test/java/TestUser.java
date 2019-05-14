import com.yexu.ssmdemo.mapper.UserMapper;
import com.yexu.ssmdemo.pojo.Device;
import com.yexu.ssmdemo.pojo.Experience;
import com.yexu.ssmdemo.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestUser {
    @Test
    public void testSelectUserByUsername(){
        ApplicationContext application=new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um=application.getBean("userMapper",UserMapper.class);
        User user=um.selectUserByUsername("15902792751");
//        System.out.println(user.toString());
        System.out.println(user.getShcool());
    }

    @Test
    public void testSelectDeviceByUsername(){
        ApplicationContext application=new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um=application.getBean("userMapper",UserMapper.class);
        List<Device> devices=um.selectDeviceByUsername("15861891135");
        for(Device device:devices){
            System.out.println(device.toString());
        }

    }
    @Test
    public void testSelectUserByDeviceId(){
        ApplicationContext application=new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um=application.getBean("userMapper",UserMapper.class);
        User user=um.selectUserByDeviceId("3033313830373031323437");
        System.out.println(user.toString());
    }
    @Test
    public void testSelectDeviceByDeviceId(){
        ApplicationContext application=new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um=application.getBean("userMapper",UserMapper.class);
        Device device=um.selectDeviceByDeviceId("3033313830373031323437");
        System.out.println(device==null);
    }
    @Test
    public void testUpdataRecordById(){
        ApplicationContext application=new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um=application.getBean("userMapper",UserMapper.class);
        Experience ex=new Experience();
        ex.setId(16069);
        ex.setLeft_degree(new Double(100));
//        System.out.println(ex.getLeft_degree());
//        System.out.println(ex.getRight_vision());
        um.updateRecord(ex);
    }

    @Test
    public void testSelectRecordById(){
        ApplicationContext application=new ClassPathXmlApplicationContext("application-dao.xml");
        UserMapper um=application.getBean("userMapper",UserMapper.class);
        Experience ep=um.selectRecordById(16069);
        System.out.println(ep.toString());
    }

}
