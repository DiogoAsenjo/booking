package com.canoacaicara.booking.dao;

import com.canoacaicara.booking.entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    List<Reservation> getAll();
    Reservation getById(int id);
    Reservation create(Reservation reservation);
    void deleteById(int id);
}
