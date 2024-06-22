package com.ensayo.mapstrcut.api.dto.response;

import java.time.LocalDate;

import com.ensayo.mapstrcut.domain.entites.BookEntity;
import com.ensayo.mapstrcut.domain.entites.UserEntity;

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

public class LoanResponse {
    private long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean status;
    private UserEntity userEntity;
    private BookEntity bookEntity;
}
