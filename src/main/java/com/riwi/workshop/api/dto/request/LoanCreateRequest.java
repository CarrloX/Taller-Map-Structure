package com.riwi.workshop.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanCreateRequest extends LoanBasicRequest {
    @NotNull(message = "el usuario id es requerido")
    private Long userId;

    @NotNull(message = "el libro id es requerido")
    private Long bookId;
}