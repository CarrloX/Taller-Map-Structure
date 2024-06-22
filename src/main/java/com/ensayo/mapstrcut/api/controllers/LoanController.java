package com.ensayo.mapstrcut.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensayo.mapstrcut.api.dto.request.LoanRequest;
import com.ensayo.mapstrcut.api.dto.response.LoanResponse;
import com.ensayo.mapstrcut.infrastructure.abstract_services.ILoanService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/loans")
public class LoanController implements GenericController<LoanRequest, LoanResponse, Long> {
    
    @Autowired
    private final ILoanService loanService;

    @PostMapping()
    public ResponseEntity<LoanResponse> create(
        @RequestBody LoanRequest request) {
        return ResponseEntity.ok(this.loanService.create(request));
    }

    @Override
    public ResponseEntity<LoanResponse> get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ResponseEntity<LoanRequest> update(LoanRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
