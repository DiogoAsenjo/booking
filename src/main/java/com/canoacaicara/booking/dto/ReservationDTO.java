package com.canoacaicara.booking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class ReservationDTO {
    @NotBlank(message = "You should inform who will use the canoe")
    private String person;

    @Future(message = "Pickup date should be higher than now")
    private Date pickupDateTime;

    @Future(message = "Return date should be higher than now")
    private Date returnDateTime;

    @NotBlank(message = "You should inform a canoe")
    private String canoe;

    @NotBlank(message = "You should inform your destination")
    private String destination;

    //Constructors
    public ReservationDTO(String person, Date pickupDateTime, Date returnDateTime, String canoe, String destination) {
        this.person = person;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.canoe = canoe;
        this.destination = destination;
    }

    public ReservationDTO() {
    }

    //Getter and setter
    public @NotBlank String getPerson() {
        return person;
    }

    public void setPerson(@NotBlank String person) {
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

    public @NotBlank String getCanoe() {
        return canoe;
    }

    public void setCanoe(@NotBlank String canoe) {
        this.canoe = canoe;
    }

    public @NotBlank String getDestination() {
        return destination;
    }

    public void setDestination(@NotBlank String destination) {
        this.destination = destination;
    }
}
