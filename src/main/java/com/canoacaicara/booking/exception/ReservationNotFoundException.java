package com.canoacaicara.booking.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
