package com.canoacaicara.booking.service;

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
        Optional<Reservation> queryResult = reservationRepository.findById(id);
        Reservation theReservation = null;

        if(queryResult.isPresent()) {
            theReservation = queryResult.get();
        } else {
            throw new RuntimeException(("Didn't found any reservation!"));
        }

        return theReservation;
    }

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation.getPerson().equals("Diogo")) throw new RuntimeException("Diogo não");
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
