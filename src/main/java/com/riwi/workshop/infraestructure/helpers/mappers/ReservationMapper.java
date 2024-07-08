package com.riwi.workshop.infraestructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.workshop.api.dto.request.ReservationCreateRequest;
import com.riwi.workshop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workshop.api.dto.response.ReservationBasicResponse;
import com.riwi.workshop.api.dto.response.ReservationResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Reservation;
import com.riwi.workshop.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = { Book.class, UserEntity.class })
public interface ReservationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "userId", target = "user.id")
    Reservation toReservationEntity(ReservationCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", source = "status")
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Reservation toReservationUpdateEntity(ReservationUpdateRequest request, @MappingTarget Reservation reservation);

    @InheritInverseConfiguration
    ReservationBasicResponse toReservationBasicResponse(Reservation reservation);

    @InheritInverseConfiguration
    ReservationResponse toReservationResponse(Reservation reservation);
}