package com.example.demo.data;
import java.io.Serializable;
public class HighSchoolSchedule {

    private String grade;
    private String session1;
    private String session2;
    private String session3;
    private String session4;
    private String session5;
    private String session6;
    private String session7;
    private String session8;

    public HighSchoolSchedule(String grade, String session1, String session2, String session3, String session4, String session5, String session6, String session7, String session8) {
        this.grade = grade;
        this.session1 = session1;
        this.session2 = session2;
        this.session3 = session3;
        this.session4 = session4;
        this.session5 = session5;
        this.session6 = session6;
        this.session7 = session7;
        this.session8 = session8;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSession1() {
        return session1;
    }

    public void setSession1(String session1) {
        this.session1 = session1;
    }

    public String getSession2() {
        return session2;
    }

    public void setSession2(String session2) {
        this.session2 = session2;
    }

    public String getSession3() {
        return session3;
    }

    public void setSession3(String session3) {
        this.session3 = session3;
    }

    public String getSession4() {
        return session4;
    }

    public void setSession4(String session4) {
        this.session4 = session4;
    }

    public String getSession5() {
        return session5;
    }

    public void setSession5(String session5) {
        this.session5 = session5;
    }

    public String getSession6() {
        return session6;
    }

    public void setSession6(String session6) {
        this.session6 = session6;
    }

    public String getSession7() {
        return session7;
    }

    public void setSession7(String session7) {
        this.session7 = session7;
    }

    public String getSession8() {
        return session8;
    }

    public void setSession8(String session8) {
        this.session8 = session8;
    }
}

