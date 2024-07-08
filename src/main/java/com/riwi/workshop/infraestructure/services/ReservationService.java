package com.riwi.workshop.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dto.request.ReservationCreateRequest;
import com.riwi.workshop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workshop.api.dto.response.ReservationBasicResponse;
import com.riwi.workshop.api.dto.response.ReservationResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Reservation;
import com.riwi.workshop.domain.entities.UserEntity;
import com.riwi.workshop.domain.repositories.BookRepository;
import com.riwi.workshop.domain.repositories.ReservationRepository;
import com.riwi.workshop.domain.repositories.UserRepository;
import com.riwi.workshop.infraestructure.abstract_services.IReservationService;
import com.riwi.workshop.infraestructure.helpers.genericMethods.GenericEntityService;
import com.riwi.workshop.infraestructure.helpers.mappers.ReservationMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final ReservationMapper reservationMapper;

    @Autowired
    private final GenericEntityService<Reservation, Long> methodsGenerciReservation;

    @Autowired
    private final GenericEntityService<UserEntity, Long> methodsGenericUser;

    @Autowired
    private final GenericEntityService<Book, Long> methodsGenericBook;

    @Override
    public ReservationBasicResponse create(ReservationCreateRequest request) {
        Reservation reservation = this.reservationMapper.toReservationEntity(request);
        reservation.setBook(methodsGenericBook.find(bookRepository, request.getBookId(), "Book"));
        reservation.setUser(methodsGenericUser.find(userRepository, request.getUserId(), "User"));
        reservation.setStatus(true);

        return this.reservationMapper.toReservationBasicResponse(this.reservationRepository.save(reservation));
    }

    @Override
    public ReservationResponse get(Long id) {
        Reservation reservation = this.methodsGenerciReservation.find(reservationRepository, id, "Reservation");
        return this.reservationMapper.toReservationResponse(reservation);
    }

    @Override
    public ReservationResponse update(ReservationUpdateRequest request, Long id) {
        Reservation reservation = this.methodsGenerciReservation.find(reservationRepository, id, "Reservation");
        reservation = this.reservationMapper.toReservationUpdateEntity(request, reservation);
        return this.reservationMapper.toReservationResponse(this.reservationRepository.save(reservation));
    }

    @Override
    public void delete(Long id) {
        Reservation reservation = this.methodsGenerciReservation.find(reservationRepository, id, "Reservation");
        this.reservationRepository.delete(reservation);
    }
}
