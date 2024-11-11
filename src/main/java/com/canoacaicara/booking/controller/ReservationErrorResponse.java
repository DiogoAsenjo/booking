package com.canoacaicara.booking.controller;

public class ReservationErrorResponse {
    private int statusCode;
    private String message;

    //Constructors
    public ReservationErrorResponse() {

    }

    public ReservationErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    //Getter and setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
