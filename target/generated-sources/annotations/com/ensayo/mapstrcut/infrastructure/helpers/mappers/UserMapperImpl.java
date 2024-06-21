package com.ensayo.mapstrcut.infrastructure.helpers.mappers;

import com.ensayo.mapstrcut.api.dto.request.UserRequest;
import com.ensayo.mapstrcut.api.dto.response.UserResponse;
import com.ensayo.mapstrcut.domain.entites.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T12:18:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toUserEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.username( userRequest.getUsername() );
        userEntity.password( userRequest.getPassword() );
        userEntity.email( userRequest.getEmail() );
        userEntity.full_name( userRequest.getFull_name() );
        userEntity.role( userRequest.getRole() );

        return userEntity.build();
    }

    @Override
    public UserResponse toUserResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( userEntity.getId() );
        userResponse.username( userEntity.getUsername() );
        userResponse.password( userEntity.getPassword() );
        userResponse.email( userEntity.getEmail() );
        userResponse.full_name( userEntity.getFull_name() );
        userResponse.role( userEntity.getRole() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> UserListToResponseList(List<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( userEntities.size() );
        for ( UserEntity userEntity : userEntities ) {
            list.add( toUserResponse( userEntity ) );
        }

        return list;
    }
}
