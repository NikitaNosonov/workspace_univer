package dev.vorstu.dto.mapper;

import dev.vorstu.dto.credential.Credential;
import dev.vorstu.entity.credential.CredentialEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T03:42:52+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class CredentialMapperImpl implements CredentialMapper {

    @Override
    public CredentialEntity dtoToEntity(Credential dto) {
        if ( dto == null ) {
            return null;
        }

        CredentialEntity.CredentialEntityBuilder credentialEntity = CredentialEntity.builder();

        credentialEntity.id( dto.getId() );
        credentialEntity.username( dto.getUsername() );
        credentialEntity.password( dto.getPassword() );
        credentialEntity.role( dto.getRole() );

        return credentialEntity.build();
    }

    @Override
    public Credential entityToDto(CredentialEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Credential.CredentialBuilder credential = Credential.builder();

        credential.id( entity.getId() );
        credential.password( entity.getPassword() );
        credential.username( entity.getUsername() );
        credential.role( entity.getRole() );

        return credential.build();
    }

    @Override
    public List<Credential> toList(List<CredentialEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Credential> list1 = new ArrayList<Credential>( list.size() );
        for ( CredentialEntity credentialEntity : list ) {
            list1.add( entityToDto( credentialEntity ) );
        }

        return list1;
    }

    @Override
    public List<CredentialEntity> toListEntity(List<Credential> list) {
        if ( list == null ) {
            return null;
        }

        List<CredentialEntity> list1 = new ArrayList<CredentialEntity>( list.size() );
        for ( Credential credential : list ) {
            list1.add( dtoToEntity( credential ) );
        }

        return list1;
    }
}
