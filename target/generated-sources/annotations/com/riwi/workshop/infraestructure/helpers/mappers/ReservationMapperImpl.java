package com.riwi.workshop.infraestructure.helpers.mappers;

import com.riwi.workshop.api.dto.request.ReservationCreateRequest;
import com.riwi.workshop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.ReservationBasicResponse;
import com.riwi.workshop.api.dto.response.ReservationResponse;
import com.riwi.workshop.api.dto.response.UserBasicResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Reservation;
import com.riwi.workshop.domain.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T16:58:36-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation toReservationEntity(ReservationCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.book( reservationCreateRequestToBook( request ) );
        reservation.user( reservationCreateRequestToUserEntity( request ) );
        reservation.reservationDate( request.getReservationDate() );

        return reservation.build();
    }

    @Override
    public Reservation toReservationUpdateEntity(ReservationUpdateRequest request, Reservation reservation) {
        if ( request == null ) {
            return reservation;
        }

        reservation.setStatus( request.isStatus() );
        reservation.setReservationDate( request.getReservationDate() );

        return reservation;
    }

    @Override
    public ReservationBasicResponse toReservationBasicResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationBasicResponse.ReservationBasicResponseBuilder<?, ?> reservationBasicResponse = ReservationBasicResponse.builder();

        reservationBasicResponse.id( reservation.getId() );
        reservationBasicResponse.reservationDate( reservation.getReservationDate() );
        reservationBasicResponse.status( reservation.isStatus() );

        return reservationBasicResponse.build();
    }

    @Override
    public ReservationResponse toReservationResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder<?, ?> reservationResponse = ReservationResponse.builder();

        reservationResponse.id( reservation.getId() );
        reservationResponse.reservationDate( reservation.getReservationDate() );
        reservationResponse.status( reservation.isStatus() );
        reservationResponse.book( bookToBookBasicResponse( reservation.getBook() ) );
        reservationResponse.user( userEntityToUserBasicResponse( reservation.getUser() ) );

        return reservationResponse.build();
    }

    protected Book reservationCreateRequestToBook(ReservationCreateRequest reservationCreateRequest) {
        if ( reservationCreateRequest == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.id( reservationCreateRequest.getBookId() );

        return book.build();
    }

    protected UserEntity reservationCreateRequestToUserEntity(ReservationCreateRequest reservationCreateRequest) {
        if ( reservationCreateRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( reservationCreateRequest.getUserId() );

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
