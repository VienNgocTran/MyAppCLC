package com.example.tnv.myappclc.model;

import java.io.Serializable;

/**
 * Created by TNV on 3/16/2018.
 */

public class Student implements Serializable {
    private int Id;
    private String UserName;
    private String Password;
    private String FullName;
    private boolean Gender;
    private String Address;

    public Student() {
    }

    public Student(int id, String userName, String password, String fullName, boolean gender, String address) {
        Id = id;
        UserName = userName;
        Password = password;
        FullName = fullName;
        Gender = gender;
        Address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
