package com.riwi.workshop.infraestructure.abstract_services;

import com.riwi.workshop.api.dto.request.LoanCreateRequest;
import com.riwi.workshop.api.dto.request.LoanUpdateRequest;
import com.riwi.workshop.api.dto.response.LoanBasicResponse;
import com.riwi.workshop.api.dto.response.LoanResponse;
import com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services.BasicCrudService;

public interface ILoanService extends
                BasicCrudService<LoanCreateRequest, LoanUpdateRequest, LoanResponse, LoanBasicResponse, Long> {
}