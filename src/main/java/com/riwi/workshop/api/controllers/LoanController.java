package com.riwi.workshop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workshop.api.controllers.BasicControllers.BasicController;
import com.riwi.workshop.api.dto.request.LoanCreateRequest;
import com.riwi.workshop.api.dto.request.LoanUpdateRequest;
import com.riwi.workshop.api.dto.response.LoanBasicResponse;
import com.riwi.workshop.api.dto.response.LoanResponse;
import com.riwi.workshop.infraestructure.abstract_services.ILoanService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/loans")
@AllArgsConstructor
public class LoanController implements
        BasicController<LoanResponse, LoanBasicResponse, LoanCreateRequest, LoanUpdateRequest> {

    @Autowired
    private final ILoanService loanService;
    @Override
    public ResponseEntity<LoanBasicResponse> insert(LoanCreateRequest request) {
        return ResponseEntity.ok(this.loanService.create(request));
    }

    @Override
    public ResponseEntity<LoanResponse> update(LoanUpdateRequest request, Long id) {
        return ResponseEntity.ok(this.loanService.update(request, id));
    }
    
    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.loanService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<LoanResponse> getById(Long id) {
        return ResponseEntity.ok(this.loanService.get(id));
    }


}
