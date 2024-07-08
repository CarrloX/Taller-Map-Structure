package com.riwi.workshop.infraestructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.workshop.api.dto.request.LoanCreateRequest;
import com.riwi.workshop.api.dto.request.LoanUpdateRequest;
import com.riwi.workshop.api.dto.response.LoanResponse;
import com.riwi.workshop.api.dto.response.LoanToUserResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = { Book.class, UserEntity.class })
public interface LoanMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "userId", target = "user.id")
    Loan toLoanEntity(LoanCreateRequest loanRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", source = "status")
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Loan toLoanUpdateEntity(LoanUpdateRequest loanRequest, @MappingTarget Loan loan);

    @InheritInverseConfiguration
    LoanResponse toLoanResponse(Loan loan);

    @InheritInverseConfiguration
    LoanToUserResponse toLoanToUserResponse(Loan loan);
}