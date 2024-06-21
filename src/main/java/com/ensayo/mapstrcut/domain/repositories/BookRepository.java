package com.ensayo.mapstrcut.domain.repositories;

import com.ensayo.mapstrcut.domain.entites.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
