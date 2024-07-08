package com.riwi.workshop.infraestructure.helpers.mappers;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.BookResponse;
import com.riwi.workshop.api.dto.response.BookToReservationResponse;
import com.riwi.workshop.api.dto.response.LoanToBookResponse;
import com.riwi.workshop.api.dto.response.ReservationToBookResponse;
import com.riwi.workshop.api.dto.response.UserBasicResponse;
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
    date = "2024-07-08T17:01:15-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toBookEntity(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.author( request.getAuthor() );
        book.genre( request.getGenre() );
        book.isbn( request.getIsbn() );
        book.publicationYear( request.getPublicationYear() );
        book.title( request.getTitle() );

        return book.build();
    }

    @Override
    public Book toBookUpdateEntity(BookRequest request, Book book) {
        if ( request == null ) {
            return book;
        }

        book.setAuthor( request.getAuthor() );
        book.setGenre( request.getGenre() );
        book.setIsbn( request.getIsbn() );
        book.setPublicationYear( request.getPublicationYear() );
        book.setTitle( request.getTitle() );

        return book;
    }

    @Override
    public BookBasicResponse toBookBasicResponse(Book book) {
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

    @Override
    public BookResponse toBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder<?, ?> bookResponse = BookResponse.builder();

        bookResponse.author( book.getAuthor() );
        bookResponse.genre( book.getGenre() );
        bookResponse.id( book.getId() );
        bookResponse.isbn( book.getIsbn() );
        bookResponse.publicationYear( book.getPublicationYear() );
        bookResponse.title( book.getTitle() );
        bookResponse.loans( loanListToLoanToBookResponseList( book.getLoans() ) );
        bookResponse.reservations( reservationListToReservationToBookResponseList( book.getReservations() ) );

        return bookResponse.build();
    }

    @Override
    public BookToReservationResponse toBookToReservationResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookToReservationResponse.BookToReservationResponseBuilder<?, ?> bookToReservationResponse = BookToReservationResponse.builder();

        bookToReservationResponse.author( book.getAuthor() );
        bookToReservationResponse.genre( book.getGenre() );
        bookToReservationResponse.id( book.getId() );
        bookToReservationResponse.isbn( book.getIsbn() );
        bookToReservationResponse.publicationYear( book.getPublicationYear() );
        bookToReservationResponse.title( book.getTitle() );
        bookToReservationResponse.reservations( reservationListToReservationToBookResponseList( book.getReservations() ) );

        return bookToReservationResponse.build();
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

    protected LoanToBookResponse loanToLoanToBookResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanToBookResponse.LoanToBookResponseBuilder<?, ?> loanToBookResponse = LoanToBookResponse.builder();

        loanToBookResponse.id( loan.getId() );
        loanToBookResponse.loanDate( loan.getLoanDate() );
        loanToBookResponse.returnDate( loan.getReturnDate() );
        loanToBookResponse.status( loan.isStatus() );
        loanToBookResponse.user( userEntityToUserBasicResponse( loan.getUser() ) );

        return loanToBookResponse.build();
    }

    protected List<LoanToBookResponse> loanListToLoanToBookResponseList(List<Loan> list) {
        if ( list == null ) {
            return null;
        }

        List<LoanToBookResponse> list1 = new ArrayList<LoanToBookResponse>( list.size() );
        for ( Loan loan : list ) {
            list1.add( loanToLoanToBookResponse( loan ) );
        }

        return list1;
    }

    protected ReservationToBookResponse reservationToReservationToBookResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationToBookResponse.ReservationToBookResponseBuilder<?, ?> reservationToBookResponse = ReservationToBookResponse.builder();

        reservationToBookResponse.id( reservation.getId() );
        reservationToBookResponse.reservationDate( reservation.getReservationDate() );
        reservationToBookResponse.status( reservation.isStatus() );
        reservationToBookResponse.user( userEntityToUserBasicResponse( reservation.getUser() ) );

        return reservationToBookResponse.build();
    }

    protected List<ReservationToBookResponse> reservationListToReservationToBookResponseList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationToBookResponse> list1 = new ArrayList<ReservationToBookResponse>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationToBookResponse( reservation ) );
        }

        return list1;
    }
}
