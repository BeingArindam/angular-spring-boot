package com.home.demo.learning.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ReservationRequest {
	private Long id;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate checkIn;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate checkOut;
	
	public ReservationRequest() {
		super();
	}

	public ReservationRequest(Long id, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

}
