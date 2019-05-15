package com.yexu.ssmdemo.mapper;

import com.yexu.ssmdemo.pojo.Device;
import com.yexu.ssmdemo.pojo.Experience;
import com.yexu.ssmdemo.pojo.StudentClass;
import com.yexu.ssmdemo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User loginAction(@Param("username") String username,@Param("password") String password);

    /**
     * 根据账号查找个人信息
     * @param username
     * @return
     */
    User selectUserByUsername(@Param("username") String username);

    /**
     * 根据账号查找绑定的设备
     * @param username
     * @return
     */
    List<Device> selectDeviceByUsername(@Param("username") String username);

    /**
     * 根据设备号查找设备
     * @param deviceId
     * @return
     */
    Device selectDeviceByDeviceId(@Param("deviceId") String deviceId);

    /**
     * 根据设备号查找用户
     * @param deviceId
     * @return
     */
    User selectUserByDeviceId(@Param("deviceId") String deviceId);

    /**
     * 删除设备(解绑)
     * @param deviceId
     * @return
     */
    Boolean deleteDeviceByDeviceId(@Param("deviceId") String deviceId);

    /**
     * 删除用户
     * @param username
     * @return
     */
    Boolean deleteUserByUsername(@Param("username") String username);

    /**
     * 查找体验记录
     * @param username
     * @return
     */
    List<Experience> selectRecordByUsername(@Param("username") String username);

    /**
     * 根据ID查找体验记录
     * @param id
     * @return
     */
    Experience selectRecordById(@Param("id") Integer id);
    /**
     * 更新体验记录
     * @param experience
     * @return
     */
    Boolean updateRecord(Experience experience);

    /**
     * 删除体验记录
     * @param id
     * @return
     */
    Boolean deleteRecord(Integer id);

    Boolean deleteAllRecord(Integer userId);

    /**
     * 查找所有用户和对应的device
     * @return
     */
    List<User> selectUserAndDevice();

//    StudentClass selectStudent(Integer classId);
}
