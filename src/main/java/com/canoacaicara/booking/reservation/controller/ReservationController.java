package com.canoacaicara.booking.reservation.controller;

import com.canoacaicara.booking.reservation.dto.ReservationDTOin;
import com.canoacaicara.booking.reservation.dto.ReservationDTOout;
import com.canoacaicara.booking.reservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation")
    public List<ReservationDTOout> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/reservation/{id}")
    public ReservationDTOout getById(@PathVariable int id) {
        return reservationService.getById(id);
    }

    @PostMapping("/reservation")
    public ReservationDTOout create(@Valid @RequestBody ReservationDTOin reservationDTOin) {
        return reservationService.create(reservationDTOin);
    }

    @PutMapping("/reservation/{id}")
    public ReservationDTOout update(@PathVariable int id, @RequestBody ReservationDTOin reservationDTOin ) {
        ReservationDTOout reservationEntityUpdated = reservationService.update(id, reservationDTOin);
        return reservationEntityUpdated;
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteById(@PathVariable int id) {
        reservationService.deleteById(id);
    }
}
