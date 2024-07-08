package com.riwi.workshop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workshop.api.controllers.BasicControllers.BasicController;
import com.riwi.workshop.api.dto.request.ReservationCreateRequest;
import com.riwi.workshop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workshop.api.dto.response.ReservationBasicResponse;
import com.riwi.workshop.api.dto.response.ReservationResponse;
import com.riwi.workshop.infraestructure.abstract_services.IReservationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
public class ReservationController implements
        BasicController<ReservationResponse, ReservationBasicResponse, ReservationCreateRequest, ReservationUpdateRequest> {

    @Autowired
    private final IReservationService reservationService;

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<ReservationBasicResponse> insert(ReservationCreateRequest request) {
        return ResponseEntity.ok(this.reservationService.create(request));
    }

    @Override
    public ResponseEntity<ReservationResponse> update(ReservationUpdateRequest request, Long id) {
        return ResponseEntity.ok(this.reservationService.update(request, id));
    }
    
    @Override
    public ResponseEntity<ReservationResponse> getById(Long id) {
        return ResponseEntity.ok(this.reservationService.get(id));
    }


}
