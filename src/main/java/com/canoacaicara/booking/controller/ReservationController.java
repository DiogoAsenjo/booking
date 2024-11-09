package com.canoacaicara.booking.controller;

import com.canoacaicara.booking.dao.ReservationDAO;
import com.canoacaicara.booking.entity.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    private ReservationDAO reservationDAO;

    public ReservationController(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @GetMapping("/reservation")
    public List<Reservation> getAll() {
        return reservationDAO.getAll();
    }
}
