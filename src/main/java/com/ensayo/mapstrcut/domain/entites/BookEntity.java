package com.ensayo.mapstrcut.domain.entites;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "book" )
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String author;
    @Column(length = 11, nullable = false)
    private Integer publication_year;
    @Column(length = 50, nullable = false)
    private String genre;
    @Column(length = 20, nullable = false)
    private String isbn;

    @OneToMany(mappedBy = "bookEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<LoanEntity> loanEntities;

    @OneToMany(mappedBy = "bookEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<ReservationEntity> reservationEntities;
}
