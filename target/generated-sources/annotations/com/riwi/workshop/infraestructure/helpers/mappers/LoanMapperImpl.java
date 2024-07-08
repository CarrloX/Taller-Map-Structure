package com.riwi.workshop.infraestructure.helpers.mappers;

import com.riwi.workshop.api.dto.request.LoanCreateRequest;
import com.riwi.workshop.api.dto.request.LoanUpdateRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.LoanResponse;
import com.riwi.workshop.api.dto.response.LoanToUserResponse;
import com.riwi.workshop.api.dto.response.UserBasicResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T16:58:33-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public Loan toLoanEntity(LoanCreateRequest loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.book( loanCreateRequestToBook( loanRequest ) );
        loan.user( loanCreateRequestToUserEntity( loanRequest ) );
        loan.loanDate( loanRequest.getLoanDate() );
        loan.returnDate( loanRequest.getReturnDate() );

        return loan.build();
    }

    @Override
    public Loan toLoanUpdateEntity(LoanUpdateRequest loanRequest, Loan loan) {
        if ( loanRequest == null ) {
            return loan;
        }

        loan.setStatus( loanRequest.isStatus() );
        loan.setLoanDate( loanRequest.getLoanDate() );
        loan.setReturnDate( loanRequest.getReturnDate() );

        return loan;
    }

    @Override
    public LoanResponse toLoanResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder<?, ?> loanResponse = LoanResponse.builder();

        loanResponse.id( loan.getId() );
        loanResponse.loanDate( loan.getLoanDate() );
        loanResponse.returnDate( loan.getReturnDate() );
        loanResponse.status( loan.isStatus() );
        loanResponse.book( bookToBookBasicResponse( loan.getBook() ) );
        loanResponse.user( userEntityToUserBasicResponse( loan.getUser() ) );

        return loanResponse.build();
    }

    @Override
    public LoanToUserResponse toLoanToUserResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanToUserResponse.LoanToUserResponseBuilder<?, ?> loanToUserResponse = LoanToUserResponse.builder();

        loanToUserResponse.id( loan.getId() );
        loanToUserResponse.loanDate( loan.getLoanDate() );
        loanToUserResponse.returnDate( loan.getReturnDate() );
        loanToUserResponse.status( loan.isStatus() );
        loanToUserResponse.book( bookToBookBasicResponse( loan.getBook() ) );

        return loanToUserResponse.build();
    }

    protected Book loanCreateRequestToBook(LoanCreateRequest loanCreateRequest) {
        if ( loanCreateRequest == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.id( loanCreateRequest.getBookId() );

        return book.build();
    }

    protected UserEntity loanCreateRequestToUserEntity(LoanCreateRequest loanCreateRequest) {
        if ( loanCreateRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( loanCreateRequest.getUserId() );

        return userEntity.build();
    }

    protected BookBasicResponse bookToBookBasicResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookBasicResponse.BookBasicResponseBuilder<?, ?> bookBasicResponse = BookBasicResponse.builder();

        bookBasicResponse.author( book.getAuthor() );
        bookBasicResponse.genre( book.getGenre() );
        bookBasicResponse.id( book.getId() );
        bookBasicResponse.isbn( book.getIsbn() );
        bookBasicResponse.publicationYear( book.getPublicationYear() );
        bookBasicResponse.title( book.getTitle() );

        return bookBasicResponse.build();
    }

    protected UserBasicResponse userEntityToUserBasicResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserBasicResponse.UserBasicResponseBuilder<?, ?> userBasicResponse = UserBasicResponse.builder();

        userBasicResponse.email( userEntity.getEmail() );
        userBasicResponse.id( userEntity.getId() );
        userBasicResponse.role( userEntity.getRole() );
        userBasicResponse.username( userEntity.getUsername() );

        return userBasicResponse.build();
    }
}
