package com.riwi.workshop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workshop.api.controllers.BasicControllers.BasicController;

import com.riwi.workshop.api.controllers.BasicControllers.GetAllController;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.BookResponse;
import com.riwi.workshop.api.dto.response.BookToReservationResponse;
import com.riwi.workshop.infraestructure.abstract_services.IBookService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookController implements
        BasicController<BookResponse, BookBasicResponse, BookRequest, BookRequest>,
        GetAllController<BookBasicResponse> {

    @Autowired
    private final IBookService bookService;

    
    @Override
    public ResponseEntity<BookResponse> getById(Long id) {
        return ResponseEntity.ok(bookService.get(id));
    }
    @Override
    public ResponseEntity<Page<BookBasicResponse>> getAll(int page, int size) {
        return ResponseEntity.ok(this.bookService.getAll(page - 1, size));
    }
    
    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}/reservations")
    public ResponseEntity<BookToReservationResponse> getAllReservations(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.getAllReservationByBook(id));
    }
    
    @Override
    public ResponseEntity<BookBasicResponse> insert(BookRequest request) {
        return ResponseEntity.ok(this.bookService.create(request));
    }
    
    @Override
    public ResponseEntity<BookResponse> update(BookRequest request, Long id) {
        return ResponseEntity.ok(this.bookService.update(request, id));
    }

}
