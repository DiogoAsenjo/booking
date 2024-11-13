package com.canoacaicara.booking.reservation.service;

import com.canoacaicara.booking.reservation.dto.ReservationDTOin;
import com.canoacaicara.booking.reservation.dto.ReservationDTOout;
import com.canoacaicara.booking.reservation.dto.ReservationMapper;
import com.canoacaicara.booking.reservation.ReservationEntity;
import com.canoacaicara.booking.reservation.exception.ReservationNotFoundException;
import com.canoacaicara.booking.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<ReservationDTOout> getAll() {
        List<ReservationEntity> allReservationEntities = reservationRepository.findAll();

        if (allReservationEntities.isEmpty()) {
            throw new ReservationNotFoundException("There's no reservation in the database");
        }

        List<ReservationDTOout> allReservationsDTO = new ArrayList<ReservationDTOout>();
        allReservationEntities.forEach(reservationEntity -> {
            ReservationDTOout reservationDTOout = ReservationMapper.INSTANCE.reservationEntityToDto(reservationEntity);
            allReservationsDTO.add(reservationDTOout);
        });

        return allReservationsDTO;
    }

    @Override
    public ReservationDTOout getById(int id) {
        ReservationEntity reservationFound = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation with id: " + id + " not found"));
        return ReservationMapper.INSTANCE.reservationEntityToDto(reservationFound);
    }

    @Override
    public ReservationDTOout create(ReservationDTOin reservationDTOin) {
        if (reservationDTOin.getPickupDateTime().after(reservationDTOin.getReturnDateTime())) throw new RuntimeException("Return date should be higher than pickup.");
        ReservationEntity reservationEntity = ReservationMapper.INSTANCE.reservationDtoToEntity(reservationDTOin);
        ReservationEntity reservationEntitySaved = reservationRepository.save(reservationEntity);
        return ReservationMapper.INSTANCE.reservationEntityToDto(reservationEntitySaved);
    }

    @Override
    public ReservationDTOout update(int id, ReservationDTOin reservationDTOin) {
        if (reservationDTOin.getPickupDateTime().after(reservationDTOin.getReturnDateTime())) throw new RuntimeException("Return date should be higher than pickup.");
        ReservationEntity reservationFound = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation with id: " + id + " not found"));
        ReservationMapper.INSTANCE.updateEntityFromDto(reservationDTOin, reservationFound);
        ReservationEntity reservationSavedWithNewData = reservationRepository.save(reservationFound);
        return ReservationMapper.INSTANCE.reservationEntityToDto(reservationSavedWithNewData);
    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
