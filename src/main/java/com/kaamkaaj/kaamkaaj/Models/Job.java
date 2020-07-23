package com.kaamkaaj.kaamkaaj.Models;

public class Job {

    private String jobid;
    private String bookingStatus;
    private String category;
  //  private String bookingDate;
   // private String bookingTime;
//    private String bookingserviceProviderEmail;
//    private String bookingserviceProviderName;
    private String customerName;
    private String customerEmail;
    private String bookingdescription;
    private String bookingImage;
    private String urgent;
    private String title;


    public Job(String jobid, String bookingStatus, String category, String customerName, String customerEmail, String bookingdescription, String bookingImage, String urgent, String title) {
        this.jobid = jobid;
        this.bookingStatus = bookingStatus;
     this.category = category;
      //  this.bookingDate = bookingDate;
       // this.bookingTime = bookingTime;
//        this.bookingserviceProviderEmail = bookingserviceProviderEmail;
//        this.bookingserviceProviderName = bookingserviceProviderName;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.bookingdescription = bookingdescription;
        this.bookingImage = bookingImage;
        this.urgent = urgent;
        this.title = title;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }
//
//    public String getBookingDate() {
//        return bookingDate;
//    }
//
//    public void setBookingDate(String bookingDate) {
//        this.bookingDate = bookingDate;
//    }

//    public String getBookingTime() {
//        return bookingTime;
//    }
//
//    public void setBookingTime(String bookingTime) {
//        this.bookingTime = bookingTime;
//    }

//    public String getBookingserviceProviderEmail() {
//        return bookingserviceProviderEmail;
//    }
//
//    public void setBookingserviceProviderEmail(String bookingserviceProviderEmail) {
//        this.bookingserviceProviderEmail = bookingserviceProviderEmail;
//    }
//
//    public String getBookingserviceProviderName() {
//        return bookingserviceProviderName;
//    }
//
//    public void setBookingserviceProviderName(String bookingserviceProviderName) {
//        this.bookingserviceProviderName = bookingserviceProviderName;
//    }

    public String getcustomerName() {
        return customerName;
    }

    public void setcustomerName(String bookingcustomerName) {
        this.customerName = bookingcustomerName;
    }

    public String getcustomerEmail() {
        return customerEmail;
    }

    public void setcustomerEmail(String bookingcustomerEmail) {
        this.customerEmail = bookingcustomerEmail;
    }

    public String getBookingdescription() {
        return bookingdescription;
    }

    public void setBookingdescription(String bookingdescription) {
        this.bookingdescription = bookingdescription;
    }

    public String getBookingImage() {
        return bookingImage;
    }

    public void setBookingImage(String bookingImage) {
        this.bookingImage = bookingImage;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

