package com.example.demo.data;

public class Schedule {

    private String Date;
    private String Time;
    private String Age;
    private String Home;
    private String Away;

    public Schedule(String date, String time, String age, String home, String away) {
        Date = date;
        Time = time;
        Age = age;
        Home = home;
        Away = away;
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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }

    public String getAway() {
        return Away;
    }

    public void setAway(String away) {
        Away = away;
    }
}
