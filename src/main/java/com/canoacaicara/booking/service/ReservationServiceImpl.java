package com.canoacaicara.booking.service;

import com.canoacaicara.booking.dao.ReservationDAO;
import com.canoacaicara.booking.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationDAO reservationDAO;

    @Autowired
    public ReservationServiceImpl(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationDAO.getAll();
    }
}
