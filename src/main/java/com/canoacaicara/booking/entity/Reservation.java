package com.canoacaicara.booking.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="person")
    private String person;

    @Column(name="pickup_datetime")
    private Date pickupDateTime;

    @Column(name="return_datetime")
    private Date returnDateTime;

    @Column(name="canoe")
    private String canoe;

    @Column(name="destination")
    private String destination;

    //Constructors
    public Reservation() {}

    public Reservation(String person, Date pickupDateTime, Date returnDateTime, String canoe, String destination) {
        this.person = person;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.canoe = canoe;
        this.destination = destination;
    }

    //Getters and Setters
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

    //toString()
    @Override
    public String toString() {
        return "Reservation{" +
                "canoe='" + canoe + '\'' +
                ", person='" + person + '\'' +
                ", destination='" + destination + '\'' +
                ", id=" + id +
                '}';
    }
}
