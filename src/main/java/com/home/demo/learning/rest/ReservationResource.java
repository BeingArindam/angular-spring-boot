package com.home.demo.learning.rest;

import static com.home.demo.learning.rest.ResourceConstants.ROOM_RESERVATION_V1;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.demo.learning.converter.RoomEntityToReservationConverter;
import com.home.demo.learning.entity.ReservationEntity;
import com.home.demo.learning.entity.RoomEntity;
import com.home.demo.learning.model.request.ReservationRequest;
import com.home.demo.learning.model.response.ReservationResponse;
import com.home.demo.learning.model.response.RoomReservationResponse;
import com.home.demo.learning.repository.PageableRoomRepository;
import com.home.demo.learning.repository.ReservationRepository;
import com.home.demo.learning.repository.RoomRepository;

@RestController
@RequestMapping(ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {
	@Autowired
	private PageableRoomRepository pageableRoomRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	private @Autowired ConversionService conversionService;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservationResponse> getAvailableRooms(
			@RequestParam("checkin") @DateTimeFormat(iso = ISO.DATE) LocalDate checkin,
			@RequestParam("checkout") @DateTimeFormat(iso = ISO.DATE) LocalDate checkout, Pageable pageable) {
		Page<RoomEntity> rooms = pageableRoomRepository.findAll(pageable);
		return rooms.map(new RoomEntityToReservationConverter());
	}

	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {
		RoomEntity room = roomRepository.findById(roomId);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {

		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
		reservationRepository.save(reservationEntity);
		RoomEntity room = roomRepository.findById(reservationRequest.getRoomId());
		room.addReservationEntity(reservationEntity);
		roomRepository.save(room);
		
		RoomReservationResponse roomReservationResponse = conversionService.convert(reservationEntity, RoomReservationResponse.class);
		
		return new ResponseEntity<>(roomReservationResponse, HttpStatus.CREATED);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> updateReservation(@RequestBody ReservationRequest reservationRequest) {
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
