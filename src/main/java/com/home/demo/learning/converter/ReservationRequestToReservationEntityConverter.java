package com.home.demo.learning.converter;

import org.springframework.core.convert.converter.Converter;

import com.home.demo.learning.entity.ReservationEntity;
import com.home.demo.learning.model.response.RoomReservationResponse;

public class ReservationRequestToReservationEntityConverter
		implements Converter<RoomReservationResponse, ReservationEntity> {
	@Override
	public ReservationEntity convert(RoomReservationResponse response) {
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(response.getCheckin());
		reservationEntity.setCheckout(response.getCheckout());
		if (response.getId() != null) {
			reservationEntity.setId(response.getId());
		}
		return reservationEntity;
	}

}
