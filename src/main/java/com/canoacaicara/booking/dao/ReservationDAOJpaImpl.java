package com.canoacaicara.booking.dao;

import com.canoacaicara.booking.entity.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDAOJpaImpl implements ReservationDAO {
    private EntityManager entityManager;

    @Autowired
    public ReservationDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Reservation> getAll() {
        TypedQuery<Reservation> queryResult = entityManager.createQuery("FROM Reservation", Reservation.class);
        return queryResult.getResultList();
    }
}
