package com.ensayo.mapstrcut.api.dto.request;

import com.ensayo.mapstrcut.domain.entites.BookEntity;
import com.ensayo.mapstrcut.domain.entites.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

    private LocalDate reservationDate;
    @NotBlank(message = "el estado de la reservacion requerido")
    private boolean status;

    private UserEntity userEntity;

    private BookEntity bookEntity;
}
