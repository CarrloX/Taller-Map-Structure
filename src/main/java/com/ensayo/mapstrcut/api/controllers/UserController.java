package com.ensayo.mapstrcut.api.controllers;

import com.ensayo.mapstrcut.api.dto.request.UserRequest;
import com.ensayo.mapstrcut.api.dto.response.UserResponse;
import com.ensayo.mapstrcut.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController implements GenericController<UserRequest, UserResponse, Long>{

    @Autowired
    private final IUserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> create(
        @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping(path = "/{Long}")
    public ResponseEntity<UserResponse> get(@PathVariable Long Long) {
        return ResponseEntity.ok(this.userService.get(Long));
    }

    @Override
    public ResponseEntity<UserRequest> update(UserRequest request, Long Long) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long Long) {
        return null;
    }
}
