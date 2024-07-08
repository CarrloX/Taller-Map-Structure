package com.riwi.workshop.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dto.request.UserCreateRequest;
import com.riwi.workshop.api.dto.request.UserUpdateRequest;
import com.riwi.workshop.api.dto.response.UserBasicResponse;
import com.riwi.workshop.api.dto.response.UserResponse;
import com.riwi.workshop.api.dto.response.UserToLoanResponse;
import com.riwi.workshop.api.dto.response.UserToReservationResponse;
import com.riwi.workshop.domain.entities.UserEntity;
import com.riwi.workshop.domain.repositories.UserRepository;
import com.riwi.workshop.infraestructure.abstract_services.IUserService;
import com.riwi.workshop.infraestructure.helpers.genericMethods.GenericEntityService;
import com.riwi.workshop.infraestructure.helpers.mappers.UserMapper;
import com.riwi.workshop.utils.enums.Role;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final GenericEntityService<UserEntity, Long> genericEntityService;

    @Override
    public UserBasicResponse create(UserCreateRequest request) {
        UserEntity userEntity = this.userMapper.toUserCreateEntity(request);
        userEntity.setRole(Role.CUSTOMER);
        return this.userMapper.toUserBasicResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserResponse get(Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        return this.userMapper.toUserResponse(userEntity);
    }

    @Override
    public UserResponse update(UserUpdateRequest request, Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        userEntity = this.userMapper.toUserUpdateEntity(request, userEntity);
        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));

    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        this.userRepository.delete(userEntity);

    }

    @Override
    public UserToLoanResponse getAllLoansByUser(Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        return this.userMapper.toUserToLoanResponse(userEntity);

    }

    @Override
    public UserToReservationResponse getAllReservationsByUser(Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        return this.userMapper.tUserToReservationResponse(userEntity);
    }
}
