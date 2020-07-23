package com.kaamkaaj.kaamkaaj.Models;

public class RatingandFeedback {

    private String rating;
    private String feedback;
    private String date;
    private String serviceProviderEmail;
    private String serviceProviderName;
    private String customerEmail;
    private String jobId;

    public RatingandFeedback(String rating, String feedback, String date, String serviceProviderEmail, String serviceProviderName, String customerEmail, String jobId) {
        this.rating = rating;
        this.feedback = feedback;
        this.date = date;
        this.serviceProviderEmail = serviceProviderEmail;
        this.serviceProviderName = serviceProviderName;
        this.customerEmail = customerEmail;
        this.jobId = jobId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServiceProviderEmail() {
        return serviceProviderEmail;
    }

    public void setServiceProviderEmail(String serviceProviderEmail) {
        this.serviceProviderEmail = serviceProviderEmail;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
