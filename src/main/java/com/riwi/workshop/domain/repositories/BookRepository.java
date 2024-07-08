package com.riwi.workshop.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.workshop.domain.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}