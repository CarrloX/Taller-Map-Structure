package com.ensayo.mapstrcut.infrastructure.abstract_services;

import com.ensayo.mapstrcut.api.dto.request.UserRequest;
import com.ensayo.mapstrcut.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, Long>{

}
