package com.canoacaicara.booking.service;

import com.canoacaicara.booking.dto.ReservationDTO;
import com.canoacaicara.booking.dto.ReservationMapper;
import com.canoacaicara.booking.exception.ReservationNotFoundException;
import com.canoacaicara.booking.dao.ReservationRepository;
import com.canoacaicara.booking.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> allReservations = reservationRepository.findAll();

        if (allReservations.isEmpty()) {
            throw new ReservationNotFoundException("There's no reservation in the database");
        }
        return allReservations;
    }

    @Override
    public Reservation getById(int id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation with id: " + id + " not found"));
    }

    @Override
    public Reservation create(ReservationDTO reservationDto) {
        if (reservationDto.getPickupDateTime().after(reservationDto.getReturnDateTime())) throw new RuntimeException("Return date should be higher than pickup.");
        Reservation reservation = ReservationMapper.INSTANCE.reservationDtoToEntity(reservationDto);
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
