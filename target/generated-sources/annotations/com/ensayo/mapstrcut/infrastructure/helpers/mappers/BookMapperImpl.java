package com.ensayo.mapstrcut.infrastructure.helpers.mappers;

import com.ensayo.mapstrcut.api.dto.request.BookRequest;
import com.ensayo.mapstrcut.api.dto.response.BookResponse;
import com.ensayo.mapstrcut.domain.entites.BookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T17:47:37-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity toBookEntity(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.author( bookRequest.getAuthor() );
        bookEntity.genre( bookRequest.getGenre() );
        bookEntity.isbn( bookRequest.getIsbn() );
        bookEntity.publication_year( bookRequest.getPublication_year() );
        bookEntity.title( bookRequest.getTitle() );

        return bookEntity.build();
    }

    @Override
    public BookResponse toBookResponse(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.author( bookEntity.getAuthor() );
        bookResponse.genre( bookEntity.getGenre() );
        bookResponse.id( bookEntity.getId() );
        bookResponse.isbn( bookEntity.getIsbn() );
        bookResponse.publication_year( bookEntity.getPublication_year() );
        bookResponse.title( bookEntity.getTitle() );

        return bookResponse.build();
    }

    @Override
    public List<BookResponse> BookListToResponseList(List<BookEntity> bookEntities) {
        if ( bookEntities == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( bookEntities.size() );
        for ( BookEntity bookEntity : bookEntities ) {
            list.add( toBookResponse( bookEntity ) );
        }

        return list;
    }
}
