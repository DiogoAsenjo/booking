package com.canoacaicara.booking.service;

import com.canoacaicara.booking.dao.ReservationDAO;
import com.canoacaicara.booking.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Reservation getById(int id) {
        return reservationDAO.getById(id);
    }

    @Transactional
    @Override
    public Reservation create(Reservation reservation) {
        return reservationDAO.create(reservation);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        reservationDAO.deleteById(id);
    }
}
