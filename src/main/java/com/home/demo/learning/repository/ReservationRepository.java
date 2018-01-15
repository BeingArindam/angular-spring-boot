package com.home.demo.learning.repository;

import org.springframework.data.repository.CrudRepository;

import com.home.demo.learning.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
