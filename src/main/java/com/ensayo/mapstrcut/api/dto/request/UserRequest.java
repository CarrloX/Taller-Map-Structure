package com.ensayo.mapstrcut.api.dto.request;

import com.ensayo.mapstrcut.utils.enums.RoleUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Email(message = "el email no es valido")
    @Size(min = 5, max = 100, message = "el email debe tener entre 5 y 100 caracteres")
    private String email;
    @NotBlank(message = "el nombre completo es requerido")
    private String full_name;
    @NotBlank(message = "el rol es requerido")
    private RoleUser role;
}
