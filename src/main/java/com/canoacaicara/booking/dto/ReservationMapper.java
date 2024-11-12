package com.canoacaicara.booking.dto;

import com.canoacaicara.booking.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation reservationDtoToEntity(ReservationDTO reservationDTO);
}

