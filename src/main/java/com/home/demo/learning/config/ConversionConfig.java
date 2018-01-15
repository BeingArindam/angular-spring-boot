package com.home.demo.learning.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.home.demo.learning.converter.ReservationEntityToRoomReservationConverter;
import com.home.demo.learning.converter.ReservationRequestToReservationEntityConverter;
import com.home.demo.learning.converter.RoomEntityToReservationConverter;

@Configuration
public class ConversionConfig {

	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<>();
		converters.add(new RoomEntityToReservationConverter());
		converters.add(new ReservationEntityToRoomReservationConverter());
		converters.add(new ReservationRequestToReservationEntityConverter());
		return converters;
	}
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		return bean.getObject();
	}
}
