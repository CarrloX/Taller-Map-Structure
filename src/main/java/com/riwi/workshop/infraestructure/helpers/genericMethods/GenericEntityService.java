package com.riwi.workshop.infraestructure.helpers.genericMethods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.riwi.workshop.utils.exceptions.IdNotFoundException;

@Service
public class GenericEntityService<T, ID> {
    public T find(JpaRepository<T, ID> repository, ID id, String entityName) {
        return repository.findById(id).orElseThrow(() -> new IdNotFoundException(entityName));
    }
}

