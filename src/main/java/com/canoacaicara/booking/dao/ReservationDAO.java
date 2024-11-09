package com.canoacaicara.booking.dao;

import com.canoacaicara.booking.entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    List<Reservation> getAll();
}
