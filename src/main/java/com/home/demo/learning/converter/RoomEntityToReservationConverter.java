package com.home.demo.learning.converter;

import org.springframework.core.convert.converter.Converter;

import com.home.demo.learning.entity.RoomEntity;
import com.home.demo.learning.model.response.Links;
import com.home.demo.learning.model.response.ReservationResponse;
import com.home.demo.learning.model.response.Self;
import static com.home.demo.learning.rest.ResourceConstants.ROOM_RESERVATION_V1;;

public class RoomEntityToReservationConverter implements Converter<RoomEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(RoomEntity entity) {
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setId(entity.getId());
		reservationResponse.setRoomNumber(entity.getRoomNumber());
		reservationResponse.setPrice(Double.valueOf(entity.getPrice()));
		Links links = new Links();
		Self self = new Self();
		links.setSelf(self);
		self.setRef(ROOM_RESERVATION_V1 + "/" + entity.getId());
		reservationResponse.setLinks(links);
		return reservationResponse;
	}
}
