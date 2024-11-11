package com.canoacaicara.booking.service;

import com.canoacaicara.booking.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();
    Reservation getById(int id);
    Reservation create(Reservation reservation);
    void deleteById(int id);
}
