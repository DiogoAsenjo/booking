package com.canoacaicara.booking.reservation.service;

import com.canoacaicara.booking.reservation.dto.ReservationDTOin;
import com.canoacaicara.booking.reservation.ReservationEntity;
import com.canoacaicara.booking.reservation.dto.ReservationDTOout;

import java.util.List;

public interface ReservationService {
    List<ReservationDTOout> getAll();
    ReservationDTOout getById(int id);
    ReservationDTOout create(ReservationDTOin reservationDTOin);
    ReservationDTOout update(int id, ReservationDTOin reservationDTOin);
    void deleteById(int id);
}
