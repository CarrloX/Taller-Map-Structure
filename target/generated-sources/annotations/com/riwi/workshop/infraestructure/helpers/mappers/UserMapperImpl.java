package com.riwi.workshop.infraestructure.helpers.mappers;

import com.riwi.workshop.api.dto.request.UserCreateRequest;
import com.riwi.workshop.api.dto.request.UserUpdateRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.LoanToUserResponse;
import com.riwi.workshop.api.dto.response.ReservationToUserResponse;
import com.riwi.workshop.api.dto.response.UserBasicResponse;
import com.riwi.workshop.api.dto.response.UserResponse;
import com.riwi.workshop.api.dto.response.UserToLoanResponse;
import com.riwi.workshop.api.dto.response.UserToReservationResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.Reservation;
import com.riwi.workshop.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T16:58:38-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toUserCreateEntity(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( request.getEmail() );
        userEntity.fullName( request.getFullName() );
        userEntity.password( request.getPassword() );
        userEntity.username( request.getUsername() );

        return userEntity.build();
    }

    @Override
    public UserEntity toUserUpdateEntity(UserUpdateRequest request, UserEntity user) {
        if ( request == null ) {
            return user;
        }

        user.setEmail( request.getEmail() );
        user.setFullName( request.getFullName() );
        user.setPassword( request.getPassword() );
        user.setRole( request.getRole() );
        user.setUsername( request.getUsername() );

        return user;
    }

    @Override
    public UserResponse toUserResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder<?, ?> userResponse = UserResponse.builder();

        userResponse.email( userEntity.getEmail() );
        userResponse.id( userEntity.getId() );
        userResponse.role( userEntity.getRole() );
        userResponse.username( userEntity.getUsername() );
        userResponse.loans( loanListToLoanToUserResponseList( userEntity.getLoans() ) );
        userResponse.reservations( reservationListToReservationToUserResponseList( userEntity.getReservations() ) );

        return userResponse.build();
    }

    @Override
    public UserBasicResponse toUserBasicResponse(UserEntity userEntity) {
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

    @Override
    public UserToLoanResponse toUserToLoanResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserToLoanResponse.UserToLoanResponseBuilder<?, ?> userToLoanResponse = UserToLoanResponse.builder();

        userToLoanResponse.email( userEntity.getEmail() );
        userToLoanResponse.id( userEntity.getId() );
        userToLoanResponse.role( userEntity.getRole() );
        userToLoanResponse.username( userEntity.getUsername() );
        userToLoanResponse.loans( loanListToLoanToUserResponseList( userEntity.getLoans() ) );

        return userToLoanResponse.build();
    }

    @Override
    public UserToReservationResponse tUserToReservationResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserToReservationResponse.UserToReservationResponseBuilder<?, ?> userToReservationResponse = UserToReservationResponse.builder();

        userToReservationResponse.email( userEntity.getEmail() );
        userToReservationResponse.id( userEntity.getId() );
        userToReservationResponse.role( userEntity.getRole() );
        userToReservationResponse.username( userEntity.getUsername() );
        userToReservationResponse.reservations( reservationListToReservationToUserResponseList( userEntity.getReservations() ) );

        return userToReservationResponse.build();
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

    protected LoanToUserResponse loanToLoanToUserResponse(Loan loan) {
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

    protected List<LoanToUserResponse> loanListToLoanToUserResponseList(List<Loan> list) {
        if ( list == null ) {
            return null;
        }

        List<LoanToUserResponse> list1 = new ArrayList<LoanToUserResponse>( list.size() );
        for ( Loan loan : list ) {
            list1.add( loanToLoanToUserResponse( loan ) );
        }

        return list1;
    }

    protected ReservationToUserResponse reservationToReservationToUserResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationToUserResponse.ReservationToUserResponseBuilder<?, ?> reservationToUserResponse = ReservationToUserResponse.builder();

        reservationToUserResponse.id( reservation.getId() );
        reservationToUserResponse.reservationDate( reservation.getReservationDate() );
        reservationToUserResponse.status( reservation.isStatus() );
        reservationToUserResponse.book( bookToBookBasicResponse( reservation.getBook() ) );

        return reservationToUserResponse.build();
    }

    protected List<ReservationToUserResponse> reservationListToReservationToUserResponseList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationToUserResponse> list1 = new ArrayList<ReservationToUserResponse>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationToUserResponse( reservation ) );
        }

        return list1;
    }
}
