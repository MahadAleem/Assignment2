package com.example.assignment2.adapter;

public class AdapterModel {
    String studentName;
    String Date;
    String Time;

    public AdapterModel(String studentName, String date, String time) {
        this.studentName = studentName;
        Date = date;
        Time = time;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
