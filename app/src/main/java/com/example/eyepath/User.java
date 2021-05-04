package com.example.eyepath;

import java.sql.Time;
import java.sql.Timestamp;

public class User {
    String email;


    public User(){
        this.email = null;

    }

    public User(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
