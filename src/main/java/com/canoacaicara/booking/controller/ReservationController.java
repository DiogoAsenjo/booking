package com.canoacaicara.booking.controller;

import com.canoacaicara.booking.entity.Reservation;
import com.canoacaicara.booking.service.ReservationService;
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
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getById(@PathVariable int id) {
        return reservationService.getById(id);
    }

    @PostMapping("/reservation")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }
}
