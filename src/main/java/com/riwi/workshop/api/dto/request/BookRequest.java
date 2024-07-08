package com.riwi.workshop.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    @Size(min = 1, max = 100, message = "el titulo debe tener entre 1 a 100 caracteres")
    @NotBlank(message = "el titulo es requerido")
    private String title;

    @Size(min = 1, max = 100, message = "el autor debe tener entre 1 a 100 caracteres")
    @NotBlank(message = "el autor es requerido")
    private String author;

    @Min(value = 1, message = "la publication del año debe ser mayor o igual a 1")
    @Max(value = 9999, message = "la publication del año debe ser menor o igual a 9999")
    @NotNull(message = "la publication year es requerido")
    private Integer publicationYear;

    @Size(min = 1, max = 50, message = "el genero debe tener entre 1 a 50 caracteres")
    @NotBlank(message = "el genero es requerido")
    private String genre;

    @Size(min = 1, max = 11, message = "el isbn debe tener entre 1 a 11 caracteres")
    @NotBlank(message = "el isbn es requerido")
    private String isbn;

}