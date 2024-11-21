package com.canoacaicara.booking.reservation.repository;

import com.canoacaicara.booking.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
