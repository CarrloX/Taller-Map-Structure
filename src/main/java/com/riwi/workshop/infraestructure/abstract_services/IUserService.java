package com.riwi.workshop.infraestructure.abstract_services;

import com.riwi.workshop.api.dto.request.UserCreateRequest;
import com.riwi.workshop.api.dto.request.UserUpdateRequest;
import com.riwi.workshop.api.dto.response.UserBasicResponse;
import com.riwi.workshop.api.dto.response.UserResponse;
import com.riwi.workshop.api.dto.response.UserToLoanResponse;
import com.riwi.workshop.api.dto.response.UserToReservationResponse;
import com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services.BasicCrudService;

public interface IUserService extends
                BasicCrudService<UserCreateRequest, UserUpdateRequest, UserResponse, UserBasicResponse, Long> {

        public UserToLoanResponse getAllLoansByUser(Long id);
        public UserToReservationResponse getAllReservationsByUser(Long id);
}
