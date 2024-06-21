package com.ensayo.mapstrcut.infrastructure.service;

import com.ensayo.mapstrcut.api.dto.request.UserRequest;
import com.ensayo.mapstrcut.api.dto.response.UserResponse;
import com.ensayo.mapstrcut.domain.entites.UserEntity;
import com.ensayo.mapstrcut.domain.repositories.UserRepository;
import com.ensayo.mapstrcut.infrastructure.abstract_services.IUserService;
import com.ensayo.mapstrcut.infrastructure.helpers.mappers.UserMapper;
import com.ensayo.mapstrcut.utils.enums.exceptions.BadRequestException;
import com.ensayo.mapstrcut.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest request) {
        UserEntity userEntity = this.userMapper.toUserEntity(request);
        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserResponse get(Long Long) {
        return this.userMapper.toUserResponse(this.find(Long));
    }

    @Override
    public UserResponse update(UserRequest request, Long Long) {
        return null;
    }

    @Override
    public void delete(Long Long) {

    }

    @Override
    public Page<UserResponse> getAll(int Page, int size) {
        return null;
    }

    private UserEntity find(Long Long) {
        return this.userRepository.findById(Long)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("servicio")));
    }
}
