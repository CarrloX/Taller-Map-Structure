package com.ensayo.mapstrcut.domain.repositories;

import com.ensayo.mapstrcut.domain.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
