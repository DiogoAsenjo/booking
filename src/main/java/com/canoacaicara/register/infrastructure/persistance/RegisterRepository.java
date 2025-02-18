package com.canoacaicara.register.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
}
