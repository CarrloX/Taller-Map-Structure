package com.ensayo.mapstrcut.api.dto.response;

import com.ensayo.mapstrcut.utils.enums.RoleUser;
import lombok.*;

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
