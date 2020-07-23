package com.kaamkaaj.kaamkaaj.Models;

public class Requests {

    private String bookingId;
    private String serviceProviderEmail;
    private String bookingState;
    private String bookingBidPrice;
    private String bookingEstimated;

    public Requests(String bookingId, String serviceProviderEmail, String bookingState, String bookingBidPrice, String bookingEstimated) {
        this.bookingId = bookingId;
        this.serviceProviderEmail = serviceProviderEmail;
        this.bookingState = bookingState;
        this.bookingBidPrice = bookingBidPrice;
        this.bookingEstimated = bookingEstimated;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getServiceProviderEmail() {
        return serviceProviderEmail;
    }

    public void setServiceProviderEmail(String serviceProviderEmail) {
        this.serviceProviderEmail = serviceProviderEmail;
    }

    public String getBookingState() {
        return bookingState;
    }

    public void setBookingState(String bookingState) {
        this.bookingState = bookingState;
    }

    public String getBookingBidPrice() {
        return bookingBidPrice;
    }

    public void setBookingBidPrice(String bookingBidPrice) {
        this.bookingBidPrice = bookingBidPrice;
    }

    public String getBookingEstimated() {
        return bookingEstimated;
    }

    public void setBookingEstimated(String bookingEstimated) {
        this.bookingEstimated = bookingEstimated;
    }
}
