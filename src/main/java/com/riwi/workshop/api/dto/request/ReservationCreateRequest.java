package com.riwi.workshop.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReservationCreateRequest {
    @FutureOrPresent(message = "la fecha de reserva debe ser hoy o una fecha posterior")
    private LocalDate reservationDate;

    @NotNull(message = "el usuario id es requerido")
    private Long userId;

    @NotNull(message = "el libro id es requerido")
    private Long bookId;
}
