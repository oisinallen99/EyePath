package com.example.eyepath;

public class Location {
    public String locationName;
    public float rating;
    public String review;

    public Location(String locationName, float rating, String review) {
        this.locationName = locationName;
        this.rating = rating;
        this.review = review;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

