package com.canoacaicara.booking.service;

import com.canoacaicara.booking.dto.ReservationDTO;
import com.canoacaicara.booking.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();
    Reservation getById(int id);
    Reservation create(ReservationDTO reservationDto);
    void deleteById(int id);
}
