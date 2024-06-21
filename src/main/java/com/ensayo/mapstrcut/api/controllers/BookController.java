package com.ensayo.mapstrcut.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensayo.mapstrcut.api.dto.request.BookRequest;
import com.ensayo.mapstrcut.api.dto.response.BookResponse;
import com.ensayo.mapstrcut.infrastructure.abstract_services.IBookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class BookController implements GenericController<BookRequest, BookResponse, Long> {

    @Autowired
    private final IBookService bookService;

    @PostMapping()
    public ResponseEntity<BookResponse> create(
            @RequestBody BookRequest request) {
        return ResponseEntity.ok(this.bookService.create(request));
    }

    @Override
    public ResponseEntity<BookResponse> get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ResponseEntity<BookRequest> update(BookRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
