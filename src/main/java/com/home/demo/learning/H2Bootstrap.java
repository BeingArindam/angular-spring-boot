package com.home.demo.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.home.demo.learning.entity.RoomEntity;
import com.home.demo.learning.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner {
	private @Autowired RoomRepository roomRepository;

	@Override
	public void run(String... args) throws Exception {
		roomRepository.save(new RoomEntity(405, "69.99"));
		roomRepository.save(new RoomEntity(406, "68.99"));
		roomRepository.save(new RoomEntity(407, "125.89"));
		roomRepository.save(new RoomEntity(408, "56.69"));

		Iterable<RoomEntity> rooms = roomRepository.findAll();
		rooms.forEach(System.out::println);
	}

}
