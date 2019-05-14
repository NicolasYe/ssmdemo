package com.yexu.ssmdemo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Experience implements Serializable {
    private static final long serialVersionUID = -626230074616785433L;
    private Integer id;
    private String user_id;
    private Double left_vision;
    private Double right_vision;
    private Double vision;
    private String experience_time;
    private String total_time;
    private Double left_degree;
    private Double right_degree;
    private Date create_time;
    private Double speed;
    private Double r_range;
    private Double increase_time;
    private Double r_day;

    public Experience() {
        super();
    }

    public Experience(Integer id, String user_id, Double left_vision, Double right_vision,Double vision, String experience_time, String total_time, Double left_degree, Double right_degree, Date create_time, Double speed, Double r_range, Double increase_time, Double r_day) {
        this.id = id;
        this.user_id = user_id;
        this.left_vision = left_vision;
        this.right_vision = right_vision;
        this.vision=vision;
        this.experience_time = experience_time;
        this.total_time = total_time;
        this.left_degree = left_degree;
        this.right_degree = right_degree;
        this.create_time = create_time;
        this.speed = speed;
        this.r_range = r_range;
        this.increase_time = increase_time;
        this.r_day = r_day;
    }

    public Double getVision() {
        return vision;
    }

    public void setVision(Double vision) {
        this.vision = vision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Double getLeft_vision() {
        return left_vision;
    }

    public void setLeft_vision(Double left_vision) {
        this.left_vision = left_vision;
    }

    public Double getRight_vision() {
        return right_vision;
    }

    public void setRight_vision(Double right_vision) {
        this.right_vision = right_vision;
    }

    public String getExperience_time() {
        return experience_time;
    }

    public void setExperience_time(String experience_time) {
        this.experience_time = experience_time;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public Double getLeft_degree() {
        return left_degree;
    }

    public void setLeft_degree(Double left_degree) {
        this.left_degree = left_degree;
    }

    public Double getRight_degree() {
        return right_degree;
    }

    public void setRight_degree(Double right_degree) {
        this.right_degree = right_degree;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getR_range() {
        return r_range;
    }

    public void setR_range(Double r_range) {
        this.r_range = r_range;
    }

    public Double getIncrease_time() {
        return increase_time;
    }

    public void setIncrease_time(Double increase_time) {
        this.increase_time = increase_time;
    }

    public Double getR_day() {
        return r_day;
    }

    public void setR_day(Double r_day) {
        this.r_day = r_day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null) return false;
        if (left_vision != null ? !left_vision.equals(that.left_vision) : that.left_vision != null) return false;
        if (right_vision != null ? !right_vision.equals(that.right_vision) : that.right_vision != null) return false;
        if (vision != null ? !vision.equals(that.vision) : that.vision != null) return false;
        if (experience_time != null ? !experience_time.equals(that.experience_time) : that.experience_time != null)
            return false;
        if (total_time != null ? !total_time.equals(that.total_time) : that.total_time != null) return false;
        if (left_degree != null ? !left_degree.equals(that.left_degree) : that.left_degree != null) return false;
        if (right_degree != null ? !right_degree.equals(that.right_degree) : that.right_degree != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (speed != null ? !speed.equals(that.speed) : that.speed != null) return false;
        if (r_range != null ? !r_range.equals(that.r_range) : that.r_range != null) return false;
        if (increase_time != null ? !increase_time.equals(that.increase_time) : that.increase_time != null)
            return false;
        return r_day != null ? r_day.equals(that.r_day) : that.r_day == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (left_vision != null ? left_vision.hashCode() : 0);
        result = 31 * result + (right_vision != null ? right_vision.hashCode() : 0);
        result = 31 * result + (vision != null ? vision.hashCode() : 0);
        result = 31 * result + (experience_time != null ? experience_time.hashCode() : 0);
        result = 31 * result + (total_time != null ? total_time.hashCode() : 0);
        result = 31 * result + (left_degree != null ? left_degree.hashCode() : 0);
        result = 31 * result + (right_degree != null ? right_degree.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (r_range != null ? r_range.hashCode() : 0);
        result = 31 * result + (increase_time != null ? increase_time.hashCode() : 0);
        result = 31 * result + (r_day != null ? r_day.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", left_vision=" + left_vision +
                ", right_vision=" + right_vision +
                ", vision=" + vision +
                ", experience_time='" + experience_time + '\'' +
                ", total_time='" + total_time + '\'' +
                ", left_degree=" + left_degree +
                ", right_degree=" + right_degree +
                ", create_time=" + create_time +
                ", speed=" + speed +
                ", r_range=" + r_range +
                ", increase_time=" + increase_time +
                ", r_day=" + r_day +
                '}';
    }
}

