package com.ensayo.mapstrcut.infrastructure.helpers.mappers;

import com.ensayo.mapstrcut.api.dto.request.LoanRequest;
import com.ensayo.mapstrcut.api.dto.response.LoanResponse;
import com.ensayo.mapstrcut.domain.entites.LoanEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T19:46:17-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public LoanEntity toLoanEntity(LoanRequest loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        LoanEntity.LoanEntityBuilder loanEntity = LoanEntity.builder();

        loanEntity.bookEntity( loanRequest.getBookEntity() );
        loanEntity.loanDate( loanRequest.getLoanDate() );
        loanEntity.returnDate( loanRequest.getReturnDate() );
        loanEntity.status( loanRequest.isStatus() );
        loanEntity.userEntity( loanRequest.getUserEntity() );

        return loanEntity.build();
    }

    @Override
    public LoanResponse toLoanResponse(LoanEntity loanEntity) {
        if ( loanEntity == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.bookEntity( loanEntity.getBookEntity() );
        loanResponse.id( loanEntity.getId() );
        loanResponse.loanDate( loanEntity.getLoanDate() );
        loanResponse.returnDate( loanEntity.getReturnDate() );
        loanResponse.status( loanEntity.isStatus() );
        loanResponse.userEntity( loanEntity.getUserEntity() );

        return loanResponse.build();
    }

    @Override
    public List<LoanResponse> LoanResponseList(List<LoanEntity> loanEntities) {
        if ( loanEntities == null ) {
            return null;
        }

        List<LoanResponse> list = new ArrayList<LoanResponse>( loanEntities.size() );
        for ( LoanEntity loanEntity : loanEntities ) {
            list.add( toLoanResponse( loanEntity ) );
        }

        return list;
    }
}
