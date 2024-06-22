package com.ensayo.mapstrcut.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ensayo.mapstrcut.api.dto.request.LoanRequest;
import com.ensayo.mapstrcut.api.dto.response.LoanResponse;
import com.ensayo.mapstrcut.domain.entites.LoanEntity;
import com.ensayo.mapstrcut.domain.repositories.LoanRepository;
import com.ensayo.mapstrcut.infrastructure.abstract_services.ILoanService;
import com.ensayo.mapstrcut.infrastructure.helpers.mappers.LoanMapper;
import com.ensayo.mapstrcut.utils.enums.exceptions.BadRequestException;
import com.ensayo.mapstrcut.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanMapper loanMapper;

    @Override
    public LoanResponse create(LoanRequest request) {
        LoanEntity loanEntity = this.loanMapper.toLoanEntity(request);
        return this.loanMapper.toLoanResponse(this.loanRepository.save(loanEntity));
    }

    @Override
    public LoanResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public LoanResponse update(LoanRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<LoanResponse> getAll(int Page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    private LoanEntity find(Long Long) {
        return this.loanRepository.findById(Long)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("servicio")));
    }

}
