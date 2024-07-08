package com.riwi.workshop.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class BookResponse extends BookBasicResponse {
    private List<LoanToBookResponse> loans;
    private List<ReservationToBookResponse> reservations;
}
