package com.gqb.pojo;

import java.util.Date;

public class StudentDetail {

    private int id;
    private int sid;
    private String tel;
    private Date date;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", sid=" + sid +
                ", tel='" + tel + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
