package com.ensayo.mapstrcut.api.dto.request;

import java.time.LocalDate;

import com.ensayo.mapstrcut.domain.entites.BookEntity;
import com.ensayo.mapstrcut.domain.entites.UserEntity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    @NotBlank(message = "el dia de la reservacion es requerida")
    private LocalDate loanDate;
    @NotBlank(message = "el dia para regresar el libro es requerido")
    private LocalDate returnDate;
    @NotBlank(message = "el estado de la reservacion es requerido")
    private boolean status;
    @NotBlank(message = "el usuario es requerido")
    private UserEntity userEntity;
    @NotBlank(message = "el libro es requerido")
    private BookEntity bookEntity;
}
