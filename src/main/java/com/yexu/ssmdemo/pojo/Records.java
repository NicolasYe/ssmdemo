package com.yexu.ssmdemo.pojo;

import java.util.List;

public class Records {
    private List<Experience> experiences;

    public Records() {
        super();
    }

    public Records(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Records records = (Records) o;

        return experiences != null ? experiences.equals(records.experiences) : records.experiences == null;
    }

    @Override
    public int hashCode() {
        return experiences != null ? experiences.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Records{" +
                "experiences=" + experiences +
                '}';
    }
}
