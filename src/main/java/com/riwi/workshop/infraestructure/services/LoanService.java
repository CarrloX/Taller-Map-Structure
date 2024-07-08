package com.riwi.workshop.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dto.request.LoanCreateRequest;
import com.riwi.workshop.api.dto.request.LoanUpdateRequest;
import com.riwi.workshop.api.dto.response.LoanBasicResponse;
import com.riwi.workshop.api.dto.response.LoanResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.UserEntity;
import com.riwi.workshop.domain.repositories.BookRepository;
import com.riwi.workshop.domain.repositories.LoanRepository;
import com.riwi.workshop.domain.repositories.UserRepository;
import com.riwi.workshop.infraestructure.abstract_services.ILoanService;
import com.riwi.workshop.infraestructure.helpers.genericMethods.GenericEntityService;
import com.riwi.workshop.infraestructure.helpers.mappers.LoanMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {
    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final LoanMapper loanMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final GenericEntityService<Loan, Long> methodsGenericService;

    @Autowired
    private final GenericEntityService<UserEntity, Long> methodsGenericUser;

    @Autowired
    private final GenericEntityService<Book, Long> methodsGenericBook;

    @Override
    public LoanBasicResponse create(LoanCreateRequest request) {
        Loan loan = this.loanMapper.toLoanEntity(request);
        loan.setStatus(true);
        loan.setBook(this.methodsGenericBook.find(bookRepository, request.getBookId(), "Book"));
        loan.setUser(this.methodsGenericUser.find(userRepository, request.getUserId(), "UserEntity"));

        return this.loanMapper.toLoanResponse(this.loanRepository.save(loan));
    }

    @Override
    public LoanResponse get(Long id) {
        Loan loan = this.methodsGenericService.find(loanRepository, id, "Loan");
        return this.loanMapper.toLoanResponse(loan);
    }

    @Override
    public LoanResponse update(LoanUpdateRequest request, Long id) {
        Loan loan = this.methodsGenericService.find(loanRepository, id, "Loan");
        loan = this.loanMapper.toLoanUpdateEntity(request, loan);
        return this.loanMapper.toLoanResponse(this.loanRepository.save(this.loanRepository.save(loan)));
    }

    @Override
    public void delete(Long id) {
        Loan loan = this.methodsGenericService.find(loanRepository, id, "Loan");
        this.loanRepository.delete(loan);
    }

}
