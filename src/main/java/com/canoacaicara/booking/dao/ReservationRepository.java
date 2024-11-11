package com.canoacaicara.booking.dao;

import com.canoacaicara.booking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
