package com.home.demo.learning.model.response;

public class ReservationResponse {
	private Long id;
	private Integer roomNumber;
	private Double price;
	private Links links;

	public ReservationResponse() {
		super();
	}

	public ReservationResponse(Integer roomNumber, Double price) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

}
