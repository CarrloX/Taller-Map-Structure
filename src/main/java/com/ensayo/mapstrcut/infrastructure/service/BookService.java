package com.ensayo.mapstrcut.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ensayo.mapstrcut.api.dto.request.BookRequest;
import com.ensayo.mapstrcut.api.dto.response.BookResponse;
import com.ensayo.mapstrcut.domain.entites.BookEntity;
import com.ensayo.mapstrcut.domain.entites.UserEntity;
import com.ensayo.mapstrcut.domain.repositories.BookRepository;
import com.ensayo.mapstrcut.infrastructure.abstract_services.IBookService;
import com.ensayo.mapstrcut.infrastructure.helpers.mappers.BookMapper;
import com.ensayo.mapstrcut.utils.enums.exceptions.BadRequestException;
import com.ensayo.mapstrcut.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    @Override
    public BookResponse create(BookRequest request) {
        BookEntity bookEntity = this.bookMapper.toBookEntity(request);
        return this.bookMapper.toBookResponse(this.bookRepository.save(bookEntity));
    }

    @Override
    public BookResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public BookResponse update(BookRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<BookResponse> getAll(int Page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    private BookEntity find(Long Long) {
        return this.bookRepository.findById(Long)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("servicio")));
    }

}
