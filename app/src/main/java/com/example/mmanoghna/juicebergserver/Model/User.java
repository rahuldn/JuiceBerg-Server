package com.example.mmanoghna.juicebergserver.Model;

/**
 * Created by m.manoghna on 1/17/2018.
 */

public class User {
    private String Name,Password,IsStaff,Phone;


    public User(String name, String password) {
        Name = name;
        Password = password;
    }
    public User()
    {}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
