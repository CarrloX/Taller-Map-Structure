package com.riwi.workshop.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanBasicRequest {
    @FutureOrPresent(message = "la fecha de devolución debe ser hoy o una fecha posterior")
    private LocalDate returnDate;

    @FutureOrPresent(message = "la fecha de prestamo debe ser hoy o una fecha posterior")
    private LocalDate loanDate;
}
