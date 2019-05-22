package com.gqb.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student {
    private int id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String[] friends;
    private List<Integer> friendsId;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", friends=" + Arrays.toString(friends) +
                ", friendsId=" + friendsId +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Integer> getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(List<Integer> friendsId) {
        this.friendsId = friendsId;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public Student() {
//        System.out.println("Student类无参构造器");
    }

    public Student(String name) {
        this.name = name;
        System.out.println(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

