package com.ensayo.mapstrcut.api.dto.response;

import com.ensayo.mapstrcut.domain.entites.LoanEntity;
import com.ensayo.mapstrcut.domain.entites.ReservationEntity;
import com.ensayo.mapstrcut.utils.enums.RoleUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String username;
    private String password;
    private String email;
    private String full_name;
    private RoleUser role;
}
