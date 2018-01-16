package com.home.demo.learning.converter;

import org.springframework.core.convert.converter.Converter;

import com.home.demo.learning.entity.ReservationEntity;
import com.home.demo.learning.model.request.ReservationRequest;
import com.home.demo.learning.model.response.RoomReservationResponse;

public class ReservationRequestToReservationEntityConverter
		implements Converter<ReservationRequest, ReservationEntity> {
	@Override
	public ReservationEntity convert(ReservationRequest request) {
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(request.getCheckin());
		reservationEntity.setCheckout(request.getCheckout());
		if (request.getId() != null) {
			reservationEntity.setId(request.getId());
		}
		return reservationEntity;
	}

}
