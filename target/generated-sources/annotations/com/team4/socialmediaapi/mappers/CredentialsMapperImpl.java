package com.team4.socialmediaapi.mappers;

import com.team4.socialmediaapi.dtos.CredentialDto;
import com.team4.socialmediaapi.entities.Credentials;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-28T23:43:53-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CredentialsMapperImpl implements CredentialsMapper {

    @Override
    public Credentials dtoToEntity(CredentialDto credentialDto) {
        if ( credentialDto == null ) {
            return null;
        }

        Credentials credentials = new Credentials();

        credentials.setUsername( credentialDto.getUsername() );
        credentials.setPassword( credentialDto.getPassword() );

        return credentials;
    }

    @Override
    public CredentialDto entityToDto(Credentials originalCredentials) {
        if ( originalCredentials == null ) {
            return null;
        }

        CredentialDto credentialDto = new CredentialDto();

        credentialDto.setUsername( originalCredentials.getUsername() );
        credentialDto.setPassword( originalCredentials.getPassword() );

        return credentialDto;
    }
}
