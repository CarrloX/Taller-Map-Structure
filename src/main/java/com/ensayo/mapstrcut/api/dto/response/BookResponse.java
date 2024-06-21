package com.ensayo.mapstrcut.api.dto.response;

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
public class BookResponse {
    private long id;
    private String title;
    private String author;
    private Integer publication_year;
    private String genre;
    private String isbn;
}
