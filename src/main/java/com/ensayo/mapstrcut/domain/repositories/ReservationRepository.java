package com.ensayo.mapstrcut.domain.repositories;

import com.ensayo.mapstrcut.domain.entites.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {
}
