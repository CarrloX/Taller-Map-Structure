package com.ensayo.mapstrcut.infrastructure.helpers.mappers;

import com.ensayo.mapstrcut.api.dto.request.UserRequest;
import com.ensayo.mapstrcut.api.dto.response.UserResponse;
import com.ensayo.mapstrcut.domain.entites.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "loanEntities", ignore = true)
    @Mapping(target = "reservationEntities",ignore = true)
    UserEntity toUserEntity(UserRequest userRequest);

    @InheritInverseConfiguration
    UserResponse toUserResponse(UserEntity userEntity);

    List<UserResponse> UserListToResponseList(List<UserEntity> userEntities);

}
