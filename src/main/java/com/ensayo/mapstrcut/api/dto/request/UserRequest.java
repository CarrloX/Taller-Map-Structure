package com.ensayo.mapstrcut.api.dto.request;

import com.ensayo.mapstrcut.utils.enums.RoleUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserRequest {
        @NotBlank(message = "el nombre de usuario es requerido")
        private String username;
        @NotBlank(message = "la contraseña es requerida")
        private String password;
        @Email
        @NotBlank(message = "el correo es requerido")
        private String email;
        @NotBlank(message = "el nombre completo es requerido")
        private String full_name;
        @NotBlank(message = "el rol es requerido")
        private RoleUser role;
    }
