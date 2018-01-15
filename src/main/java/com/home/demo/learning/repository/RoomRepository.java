package com.home.demo.learning.repository;

import org.springframework.data.repository.CrudRepository;

import com.home.demo.learning.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	public RoomEntity findById(Long id);
}
