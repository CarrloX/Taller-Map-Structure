package com.ensayo.mapstrcut.infrastructure.abstract_services;

import com.ensayo.mapstrcut.api.dto.request.BookRequest;
import com.ensayo.mapstrcut.api.dto.response.BookResponse;

public interface IBookService extends CrudService<BookRequest, BookResponse, Long> {
    
}
