package com.riwi.workshop.infraestructure.abstract_services;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.BookResponse;
import com.riwi.workshop.api.dto.response.BookToReservationResponse;
import com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services.BasicCrudService;
import com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services.GetAllService;

public interface IBookService extends
                BasicCrudService<BookRequest, BookRequest, BookResponse, BookBasicResponse, Long>,
                GetAllService<BookBasicResponse> {

        public BookToReservationResponse getAllReservationByBook(Long id);
}