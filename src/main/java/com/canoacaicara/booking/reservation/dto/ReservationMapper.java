package com.canoacaicara.booking.reservation.dto;

import com.canoacaicara.booking.reservation.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationEntity reservationDtoToEntity(ReservationDTOin reservationDTOin);

    ReservationDTOout reservationEntityToDto(ReservationEntity reservationEntity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ReservationDTOin reservationDTOin, @MappingTarget ReservationEntity reservationEntity);
}


