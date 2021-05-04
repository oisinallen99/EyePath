package com.example.eyepath;

public class CompletedActivity {
    String userID;
    String timestamp;

    public CompletedActivity(){
        this.userID = null;
        this.timestamp = null;
    }

    public CompletedActivity(String userID, String timestamp){
        this.userID = userID;
        this.timestamp = timestamp;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
