package com.riwi.workshop.api.controllers.BasicControllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public interface GetByIdController<RESPONSE> {
    @GetMapping("/{id}")
    public ResponseEntity<RESPONSE> getById(@PathVariable Long id);
}
