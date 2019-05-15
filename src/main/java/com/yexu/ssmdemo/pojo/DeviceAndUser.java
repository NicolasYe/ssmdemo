package com.yexu.ssmdemo.pojo;

public class DeviceAndUser {
    private String id;
    private Integer user_id;
    private Device device;

    public DeviceAndUser() {
        super();
    }

    public DeviceAndUser(String id, Integer user_id, Device device) {
        this.id = id;
        this.user_id = user_id;
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "DeviceAndUser{" +
                "id='" + id + '\'' +
                ", user_id=" + user_id +
                ", device=" + device +
                '}';
    }
}
