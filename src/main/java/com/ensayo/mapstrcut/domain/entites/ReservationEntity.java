package com.ensayo.mapstrcut.domain.entites;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "reservation" )
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate reservationDate;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity bookEntity;
}
