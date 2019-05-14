package com.yexu.ssmdemo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
    private static final long serialVersionUID = 1710898920877044841L;
    private String id;
    private String device_id;
    private String pid;
    private String system_type;
    private String system_version;
    private String device_name;
    private Date regiter_time;

    public Device() {
        super();
    }

    public Device(String id, String device_id, String pid, String system_type, String system_version, String device_name, Date regiter_time) {
        this.id = id;
        this.device_id = device_id;
        this.pid = pid;
        this.system_type = system_type;
        this.system_version = system_version;
        this.device_name = device_name;
        this.regiter_time = regiter_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSystem_type() {
        return system_type;
    }

    public void setSystem_type(String system_type) {
        this.system_type = system_type;
    }

    public String getSystem_version() {
        return system_version;
    }

    public void setSystem_version(String system_version) {
        this.system_version = system_version;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public Date getRegiter_time() {
        return regiter_time;
    }

    public void setRegiter_time(Date regiter_time) {
        this.regiter_time = regiter_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (id != null ? !id.equals(device.id) : device.id != null) return false;
        if (device_id != null ? !device_id.equals(device.device_id) : device.device_id != null) return false;
        if (pid != null ? !pid.equals(device.pid) : device.pid != null) return false;
        if (system_type != null ? !system_type.equals(device.system_type) : device.system_type != null) return false;
        if (system_version != null ? !system_version.equals(device.system_version) : device.system_version != null)
            return false;
        if (device_name != null ? !device_name.equals(device.device_name) : device.device_name != null) return false;
        return regiter_time != null ? regiter_time.equals(device.regiter_time) : device.regiter_time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (device_id != null ? device_id.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (system_type != null ? system_type.hashCode() : 0);
        result = 31 * result + (system_version != null ? system_version.hashCode() : 0);
        result = 31 * result + (device_name != null ? device_name.hashCode() : 0);
        result = 31 * result + (regiter_time != null ? regiter_time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", pid='" + pid + '\'' +
                ", system_type='" + system_type + '\'' +
                ", system_version='" + system_version + '\'' +
                ", device_name='" + device_name + '\'' +
                ", regiter_time=" + regiter_time +
                '}';
    }
}
