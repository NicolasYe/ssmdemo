package com.yexu.ssmdemo.pojo;

import java.util.List;

public class StudentClass {
    private Integer classId;
    private String className;
    private List<Student> students;

    public StudentClass() {
        super();
    }

    public StudentClass(Integer classId, String className, List<Student> students) {
        this.classId = classId;
        this.className = className;
        this.students = students;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", students=" + students +
                '}';
    }
}
