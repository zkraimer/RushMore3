package com.example.zachary.rushmore;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String organization;
    private int status;
    private String description = "";

    public Customer(String first, String last, String user, String pass, int stat){
         firstName = first;
         lastName = last;
         username = user;
         password = pass;
         organization = "";
         status = stat;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getOrganization() { return organization; }

    //Status of 0 means that the profile is not a member
    //Status of 1 means that the profile is a member of an organization
    //Status of 2 means that the profile is an admin of an organization
    public int getStatus() { return status; }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getDescription() { return description;}

    public void setFirstName(String first) { firstName = first; }
    public void setLastName(String last) { lastName = last; }
    public void setUsername(String user) { username = user; }
    public void setPassword(String pass) { password = pass; }
    public void setDescription(String desc) { description = desc; }
}
