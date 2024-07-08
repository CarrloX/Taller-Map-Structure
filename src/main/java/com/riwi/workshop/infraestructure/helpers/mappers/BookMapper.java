package com.riwi.workshop.infraestructure.helpers.mappers;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.BookResponse;
import com.riwi.workshop.api.dto.response.BookToReservationResponse;
import com.riwi.workshop.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book toBookEntity(BookRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book toBookUpdateEntity(BookRequest request, @MappingTarget Book book);

    @InheritConfiguration
    BookBasicResponse toBookBasicResponse(Book book);

    @InheritConfiguration
    BookResponse toBookResponse(Book book);

    @InheritConfiguration
    BookToReservationResponse toBookToReservationResponse(Book book);
}
