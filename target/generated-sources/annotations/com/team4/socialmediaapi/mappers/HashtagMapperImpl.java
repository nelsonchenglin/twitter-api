package com.team4.socialmediaapi.mappers;

import com.team4.socialmediaapi.dtos.HashtagDto;
import com.team4.socialmediaapi.entities.Hashtag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-28T23:43:53-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class HashtagMapperImpl implements HashtagMapper {

    @Override
    public List<HashtagDto> entitiesToDtos(List<Hashtag> allHashtags) {
        if ( allHashtags == null ) {
            return null;
        }

        List<HashtagDto> list = new ArrayList<HashtagDto>( allHashtags.size() );
        for ( Hashtag hashtag : allHashtags ) {
            list.add( entityToDto( hashtag ) );
        }

        return list;
    }

    @Override
    public HashtagDto entityToDto(Hashtag hashtag) {
        if ( hashtag == null ) {
            return null;
        }

        HashtagDto hashtagDto = new HashtagDto();

        hashtagDto.setLabel( hashtag.getLabel() );
        hashtagDto.setFirstUsed( hashtag.getFirstUsed() );
        hashtagDto.setLastUsed( hashtag.getLastUsed() );

        return hashtagDto;
    }

    @Override
    public Hashtag dtoToEntity(HashtagDto dto) {
        if ( dto == null ) {
            return null;
        }

        Hashtag hashtag = new Hashtag();

        hashtag.setLabel( dto.getLabel() );
        hashtag.setFirstUsed( dto.getFirstUsed() );
        hashtag.setLastUsed( dto.getLastUsed() );

        return hashtag;
    }
}
