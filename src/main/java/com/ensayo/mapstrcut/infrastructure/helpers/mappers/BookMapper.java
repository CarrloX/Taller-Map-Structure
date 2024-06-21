package com.ensayo.mapstrcut.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ensayo.mapstrcut.api.dto.request.BookRequest;
import com.ensayo.mapstrcut.api.dto.response.BookResponse;
import com.ensayo.mapstrcut.domain.entites.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
    
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "loanEntities", ignore = true)
    @Mapping(target = "reservationEntities",ignore = true)
    BookEntity toBookEntity(BookRequest bookRequest);

    @InheritInverseConfiguration
    BookResponse toBookResponse(BookEntity bookEntity);

    List<BookResponse> BookListToResponseList(List<BookEntity> bookEntities);
}
