package com.canoacaicara.booking.reservation.dto;

import java.util.Date;

public class ReservationDTOout {

    private int id;

    private String person;

    private Date pickupDateTime;

    private Date returnDateTime;

    private String canoe;

    private String destination;

    //Constructors
    public ReservationDTOout(int id, String person, Date pickupDateTime, Date returnDateTime, String canoe, String destination) {
        this.id = id;
        this.person = person;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.canoe = canoe;
        this.destination = destination;
    }

    public ReservationDTOout() {
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(Date pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public Date getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public String getCanoe() {
        return canoe;
    }

    public void setCanoe(String canoe) {
        this.canoe = canoe;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
