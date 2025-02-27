package com.team4.socialmediaapi.mappers;

import com.team4.socialmediaapi.dtos.CredentialDto;
import com.team4.socialmediaapi.dtos.ProfileDto;
import com.team4.socialmediaapi.dtos.TweetRequestDto;
import com.team4.socialmediaapi.dtos.TweetResponseDto;
import com.team4.socialmediaapi.dtos.UserResponseDto;
import com.team4.socialmediaapi.entities.Credentials;
import com.team4.socialmediaapi.entities.Profile;
import com.team4.socialmediaapi.entities.Tweet;
import com.team4.socialmediaapi.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-28T23:43:53-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TweetMapperImpl implements TweetMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public TweetResponseDto entityToDto(Tweet tweet) {
        if ( tweet == null ) {
            return null;
        }

        TweetResponseDto tweetResponseDto = new TweetResponseDto();

        tweetResponseDto.setId( tweet.getId() );
        tweetResponseDto.setPosted( tweet.getPosted() );
        tweetResponseDto.setAuthor( userMapper.entityToDto( tweet.getAuthor() ) );
        tweetResponseDto.setRepostOf( entityToRequestDto( tweet.getRepostOf() ) );
        tweetResponseDto.setInReplyTo( entityToDto( tweet.getInReplyTo() ) );
        tweetResponseDto.setContent( tweet.getContent() );

        return tweetResponseDto;
    }

    @Override
    public Tweet dtoToEntity(TweetRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tweet tweet = new Tweet();

        tweet.setContent( dto.getContent() );

        return tweet;
    }

    @Override
    public TweetRequestDto entityToRequestDto(Tweet tweet) {
        if ( tweet == null ) {
            return null;
        }

        TweetRequestDto tweetRequestDto = new TweetRequestDto();

        tweetRequestDto.setContent( tweet.getContent() );

        return tweetRequestDto;
    }

    @Override
    public Tweet responseDtoToEntity(TweetResponseDto tweetResponseDto) {
        if ( tweetResponseDto == null ) {
            return null;
        }

        Tweet tweet = new Tweet();

        tweet.setId( tweetResponseDto.getId() );
        tweet.setAuthor( userResponseDtoToUser( tweetResponseDto.getAuthor() ) );
        tweet.setPosted( tweetResponseDto.getPosted() );
        tweet.setContent( tweetResponseDto.getContent() );
        tweet.setInReplyTo( responseDtoToEntity( tweetResponseDto.getInReplyTo() ) );
        tweet.setRepostOf( dtoToEntity( tweetResponseDto.getRepostOf() ) );

        return tweet;
    }

    @Override
    public List<TweetResponseDto> setEntitiesToDtos(Set<Tweet> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TweetResponseDto> list = new ArrayList<TweetResponseDto>( entities.size() );
        for ( Tweet tweet : entities ) {
            list.add( entityToDto( tweet ) );
        }

        return list;
    }

    @Override
    public List<TweetResponseDto> entitiesToDtos(List<Tweet> tweet) {
        if ( tweet == null ) {
            return null;
        }

        List<TweetResponseDto> list = new ArrayList<TweetResponseDto>( tweet.size() );
        for ( Tweet tweet1 : tweet ) {
            list.add( entityToDto( tweet1 ) );
        }

        return list;
    }

    protected Profile profileDtoToProfile(ProfileDto profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setFirstName( profileDto.getFirstName() );
        profile.setLastName( profileDto.getLastName() );
        profile.setEmail( profileDto.getEmail() );
        profile.setPhone( profileDto.getPhone() );

        return profile;
    }

    protected Credentials credentialDtoToCredentials(CredentialDto credentialDto) {
        if ( credentialDto == null ) {
            return null;
        }

        Credentials credentials = new Credentials();

        credentials.setUsername( credentialDto.getUsername() );
        credentials.setPassword( credentialDto.getPassword() );

        return credentials;
    }

    protected User userResponseDtoToUser(UserResponseDto userResponseDto) {
        if ( userResponseDto == null ) {
            return null;
        }

        User user = new User();

        user.setProfile( profileDtoToProfile( userResponseDto.getProfile() ) );
        user.setCredentials( credentialDtoToCredentials( userResponseDto.getCredentials() ) );
        user.setJoined( userResponseDto.getJoined() );

        return user;
    }
}
