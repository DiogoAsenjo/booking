package com.canoacaicara.booking.service;

import com.canoacaicara.booking.controller.ReservationNotFoundException;
import com.canoacaicara.booking.dao.ReservationRepository;
import com.canoacaicara.booking.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(int id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation with id:" + id + "not found"));
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
