package com.yexu.ssmdemo.service.interfaces;


import com.yexu.ssmdemo.pojo.DeviceUser;
import com.yexu.ssmdemo.pojo.Experience;
import com.yexu.ssmdemo.pojo.Records;
import com.yexu.ssmdemo.pojo.User;

public interface IUserService {
    User checkLogin(String username,String password);
    DeviceUser searchByUsername(String username);
    DeviceUser searchByBarCode(String barCode);
    Boolean ubindByUsernameOrBarCode(String barCode, String username);
    Boolean deleteUser(String username);
    Records searchRecord(String username);
    void updateRecord(Experience experience);
    void deleteRecord(String id);
    void deleteAllRecord(String userId);
}
