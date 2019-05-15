package com.yexu.ssmdemo.pojo;

public class Student {
    private Integer stuno;
    private String name;
    private Integer classId;

    public Student() {
        super();
    }

    public Student(Integer stuno, String name, Integer classId) {
        this.stuno = stuno;
        this.name = name;
        this.classId = classId;
    }

    public Integer getStuno() {
        return stuno;
    }

    public void setStuno(Integer stuno) {
        this.stuno = stuno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno=" + stuno +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                '}';
    }
}
