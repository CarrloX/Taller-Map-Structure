package com.ensayo.mapstrcut.infrastructure.abstract_services;

import com.ensayo.mapstrcut.api.dto.request.LoanRequest;
import com.ensayo.mapstrcut.api.dto.response.LoanResponse;

public interface ILoanService extends CrudService<LoanRequest, LoanResponse, Long> {
    
}
