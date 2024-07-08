package com.riwi.workshop.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.response.BookBasicResponse;
import com.riwi.workshop.api.dto.response.BookResponse;
import com.riwi.workshop.api.dto.response.BookToReservationResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.repositories.BookRepository;
import com.riwi.workshop.infraestructure.abstract_services.IBookService;
import com.riwi.workshop.infraestructure.helpers.genericMethods.GenericEntityService;
import com.riwi.workshop.infraestructure.helpers.mappers.BookMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookMapper bookMapper;

    @Autowired
    private final GenericEntityService<Book, Long> genericEntityService;

    @Override
    public BookBasicResponse create(BookRequest request) {
        Book book = this.bookMapper.toBookEntity(request);
        return this.bookMapper.toBookBasicResponse(this.bookRepository.save(book));

    }

    @Override
    public BookResponse get(Long id) {
        Book book = this.genericEntityService.find(bookRepository, id, "Book");
        return this.bookMapper.toBookResponse(book);
    }

    @Override
    public BookResponse update(BookRequest request, Long id) {
        Book book = this.genericEntityService.find(bookRepository, id, "Book");
        book = this.bookMapper.toBookUpdateEntity(request, book);
        return this.bookMapper.toBookResponse(this.bookRepository.save(book));

    }

    @Override
    public void delete(Long id) {
        Book book = this.genericEntityService.find(bookRepository, id, "Book");
        this.bookRepository.delete(book);
    }

    @Override
    public Page<BookBasicResponse> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        PageRequest pagination = PageRequest.of(page, size);
        return this.bookRepository.findAll(pagination).map(book -> bookMapper.toBookBasicResponse(book));

    }

    @Override
    public BookToReservationResponse getAllReservationByBook(Long id) {
        Book book = this.genericEntityService.find(bookRepository, id, "Book");
        return this.bookMapper.toBookToReservationResponse(book);
    }
}
