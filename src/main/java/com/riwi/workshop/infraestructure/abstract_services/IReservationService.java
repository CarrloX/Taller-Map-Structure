package com.riwi.workshop.infraestructure.abstract_services;

import com.riwi.workshop.api.dto.request.ReservationCreateRequest;
import com.riwi.workshop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workshop.api.dto.response.ReservationBasicResponse;
import com.riwi.workshop.api.dto.response.ReservationResponse;
import com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services.BasicCrudService;

public interface IReservationService extends
        BasicCrudService<ReservationCreateRequest, ReservationUpdateRequest, ReservationResponse, ReservationBasicResponse, Long> {
}
