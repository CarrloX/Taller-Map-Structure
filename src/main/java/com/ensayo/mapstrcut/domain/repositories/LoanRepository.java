package com.ensayo.mapstrcut.domain.repositories;

import com.ensayo.mapstrcut.domain.entites.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Long> {
}
