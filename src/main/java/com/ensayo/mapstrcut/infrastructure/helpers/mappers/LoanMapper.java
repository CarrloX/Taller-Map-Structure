package com.ensayo.mapstrcut.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ensayo.mapstrcut.api.dto.request.LoanRequest;
import com.ensayo.mapstrcut.api.dto.response.LoanResponse;
import com.ensayo.mapstrcut.domain.entites.LoanEntity;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mapping(target = "id",ignore = true)
    LoanEntity toLoanEntity(LoanRequest loanRequest);

    @InheritInverseConfiguration
    LoanResponse toLoanResponse(LoanEntity loanEntity);

    List<LoanResponse> LoanResponseList(List<LoanEntity> loanEntities);
}