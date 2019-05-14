package com.yexu.ssmdemo.pojo;

import java.io.Serializable;
import java.util.List;

public class DeviceUser implements Serializable {
    private static final long serialVersionUID = 7668693898679364151L;
    private User user;
    private List<Device> devices;

    public DeviceUser() {
        super();
    }

    public DeviceUser(User user, List<Device> devices) {
        this.user = user;
        this.devices = devices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceUser that = (DeviceUser) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return devices != null ? devices.equals(that.devices) : that.devices == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceUser{" +
                "user=" + user +
                ", devices=" + devices +
                '}';
    }
}
