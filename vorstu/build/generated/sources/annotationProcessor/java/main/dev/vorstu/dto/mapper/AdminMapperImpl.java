package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Admin;
import dev.vorstu.entity.AdminEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T15:21:36+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminEntity dtoToEntity(Admin dto) {
        if ( dto == null ) {
            return null;
        }

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setId( dto.getId() );
        adminEntity.setName( dto.getName() );
        adminEntity.setCredentialId( dto.getCredentialId() );

        return adminEntity;
    }

    @Override
    public Admin entityToDto(AdminEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Admin.AdminBuilder admin = Admin.builder();

        admin.id( entity.getId() );
        admin.name( entity.getName() );
        admin.credentialId( entity.getCredentialId() );

        return admin.build();
    }

    @Override
    public List<Admin> toList(List<AdminEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Admin> list1 = new ArrayList<Admin>( list.size() );
        for ( AdminEntity adminEntity : list ) {
            list1.add( entityToDto( adminEntity ) );
        }

        return list1;
    }

    @Override
    public List<AdminEntity> toListEntity(List<Admin> list) {
        if ( list == null ) {
            return null;
        }

        List<AdminEntity> list1 = new ArrayList<AdminEntity>( list.size() );
        for ( Admin admin : list ) {
            list1.add( dtoToEntity( admin ) );
        }

        return list1;
    }
}
