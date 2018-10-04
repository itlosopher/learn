package org.xyc.domain;

public class Student {
    private String name;
    private String location;
    private double grade;
    private String idcard;
    private String examid;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getGrade() {
        return grade;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getExamid() {
        return examid;
    }
}
