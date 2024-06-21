package com.ensayo.mapstrcut.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotBlank(message = "el tituloes requerido")
    private String title;
    @NotBlank(message = "el autor es requerido")
    private String author;
    @NotBlank(message = "el año de publicacion es requerido")
    private Integer publication_year;
    @NotBlank(message = "el genero es requerido")
    private String genre;
    @NotBlank(message = "el ISBN es requerido")
    private String isbn;
}
