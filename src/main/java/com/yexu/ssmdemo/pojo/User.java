package com.yexu.ssmdemo.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 2407423474133869478L;

    Integer id;
    String username;
    String password;
    String head_portrait;
    String real_name;
    Integer sex;
    Integer age;
    Double optician_left;
    Double optician_right;
    Double naked_left;
    Double naked_right;
    Double naked;
    Double wear_left;
    Double wear_right;
    Double interpupillary_distance;
    String shcool;
    String address;
    Integer shop_code;
    Integer register_id;
    Double balance;
    Date create_time;
    String validate_code;
    DeviceAndUser deviceAndUser;

    public User() {
        super();
    }

    public User(Integer id, String username, String password, String head_portrait, String real_name, Integer sex, Integer age, Double optician_left, Double optician_right, Double naked_left, Double naked_right, Double naked, Double wear_left, Double wear_right, Double interpupillary_distance, String shcool, String address, Integer shop_code, Integer register_id, Double balance, Date create_time, String validate_code, DeviceAndUser deviceAndUser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.head_portrait = head_portrait;
        this.real_name = real_name;
        this.sex = sex;
        this.age = age;
        this.optician_left = optician_left;
        this.optician_right = optician_right;
        this.naked_left = naked_left;
        this.naked_right = naked_right;
        this.naked = naked;
        this.wear_left = wear_left;
        this.wear_right = wear_right;
        this.interpupillary_distance = interpupillary_distance;
        this.shcool = shcool;
        this.address = address;
        this.shop_code = shop_code;
        this.register_id = register_id;
        this.balance = balance;
        this.create_time = create_time;
        this.validate_code = validate_code;
        this.deviceAndUser = deviceAndUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getOptician_left() {
        return optician_left;
    }

    public void setOptician_left(Double optician_left) {
        this.optician_left = optician_left;
    }

    public Double getOptician_right() {
        return optician_right;
    }

    public void setOptician_right(Double optician_right) {
        this.optician_right = optician_right;
    }

    public Double getNaked_left() {
        return naked_left;
    }

    public void setNaked_left(Double naked_left) {
        this.naked_left = naked_left;
    }

    public Double getNaked_right() {
        return naked_right;
    }

    public void setNaked_right(Double naked_right) {
        this.naked_right = naked_right;
    }

    public Double getNaked() {
        return naked;
    }

    public void setNaked(Double naked) {
        this.naked = naked;
    }

    public Double getWear_left() {
        return wear_left;
    }

    public void setWear_left(Double wear_left) {
        this.wear_left = wear_left;
    }

    public Double getWear_right() {
        return wear_right;
    }

    public void setWear_right(Double wear_right) {
        this.wear_right = wear_right;
    }

    public Double getInterpupillary_distance() {
        return interpupillary_distance;
    }

    public void setInterpupillary_distance(Double interpupillary_distance) {
        this.interpupillary_distance = interpupillary_distance;
    }

    public String getShcool() {
        return shcool;
    }

    public void setShcool(String shcool) {
        this.shcool = shcool;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getShop_code() {
        return shop_code;
    }

    public void setShop_code(Integer shop_code) {
        this.shop_code = shop_code;
    }

    public Integer getRegister_id() {
        return register_id;
    }

    public void setRegister_id(Integer register_id) {
        this.register_id = register_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getValidate_code() {
        return validate_code;
    }

    public void setValidate_code(String validate_code) {
        this.validate_code = validate_code;
    }

    public DeviceAndUser getDeviceAndUser() {
        return deviceAndUser;
    }

    public void setDeviceAndUser(DeviceAndUser deviceAndUser) {
        this.deviceAndUser = deviceAndUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", head_portrait='" + head_portrait + '\'' +
                ", real_name='" + real_name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", optician_left=" + optician_left +
                ", optician_right=" + optician_right +
                ", naked_left=" + naked_left +
                ", naked_right=" + naked_right +
                ", naked=" + naked +
                ", wear_left=" + wear_left +
                ", wear_right=" + wear_right +
                ", interpupillary_distance=" + interpupillary_distance +
                ", shcool='" + shcool + '\'' +
                ", address='" + address + '\'' +
                ", shop_code=" + shop_code +
                ", register_id=" + register_id +
                ", balance=" + balance +
                ", create_time=" + create_time +
                ", validate_code='" + validate_code + '\'' +
                ", deviceAndUser=" + deviceAndUser +
                '}';
    }
}
