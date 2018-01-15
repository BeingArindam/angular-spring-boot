package com.home.demo.learning.converter;

import org.springframework.core.convert.converter.Converter;

import com.home.demo.learning.entity.ReservationEntity;
import com.home.demo.learning.model.response.RoomReservationResponse;

public class ReservationEntityToRoomReservationConverter implements Converter<ReservationEntity, RoomReservationResponse> {

	@Override
	public RoomReservationResponse convert(ReservationEntity entity) {
		RoomReservationResponse response = new RoomReservationResponse();
		response.setId(entity.getId());
		response.setCheckin(entity.getCheckin());
		response.setCheckout(entity.getCheckout());
		return response;
	}
	
}
