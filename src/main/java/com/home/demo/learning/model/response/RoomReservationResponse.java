package com.home.demo.learning.model.response;

import java.time.LocalDate;

public class RoomReservationResponse {
	private Long id;
	private LocalDate checkin;
	private LocalDate checkout;

	public RoomReservationResponse() {
		super();
	}

	public RoomReservationResponse(Long id, LocalDate checkin, LocalDate checkout) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

}
