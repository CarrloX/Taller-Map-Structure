package com.riwi.workshop.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanBasicResponse {
    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean status;
}