package com.kaamkaaj.kaamkaaj.Models;

public class ServiceProvider {
    private String userId;
    private String userName;
    private String userEmail;
    private String userContact;
    private String userAddress;
    private String userCategory;
    private String userPicture;
    private String userLat;
    private String userLon;
    private int userJobs;

    public ServiceProvider(String userId, String userName, String userEmail, String userContact, String userAddress, String userCategory, String userPicture, String userLat, String userLon, int userJobs) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
        this.userAddress = userAddress;
        this.userCategory = userCategory;
        this.userPicture = userPicture;
        this.userLat = userLat;
        this.userLon = userLon;
        this.userJobs = userJobs;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserLat() {
        return userLat;
    }

    public void setUserLat(String userLat) {
        this.userLat = userLat;
    }

    public String getUserLon() {
        return userLon;
    }

    public void setUserLon(String userLon) {
        this.userLon = userLon;
    }

    public int getUserJobs() {
        return userJobs;
    }

    public void setUserJobs(int userJobs) {
        this.userJobs = userJobs;
    }
}
