package com.example.studentstatus.attendence.model;


public class StudentModel {

    String roll;
    String name;
    String absent;
    String present;
    String percent;



    public StudentModel(String roll, String name, String absent, String present, String percent) {
        this.roll = roll;
        this.name = name;
        this.absent = absent;
        this.present = present;
        this.percent = percent;
    }
//    public Model(){}

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

