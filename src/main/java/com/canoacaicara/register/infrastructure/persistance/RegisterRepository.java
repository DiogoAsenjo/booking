package com.canoacaicara.register.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
    List<RegisterEntity> findByUserId(int userId);
}
