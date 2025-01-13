package dev.vorstu.dto.mapper;

import dev.vorstu.dto.User;
import dev.vorstu.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T03:42:51+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    private final RentalMapper rentalMapper;
    private final BusinessPersonMapper businessPersonMapper;

    @Autowired
    public UserMapperImpl(RentalMapper rentalMapper, BusinessPersonMapper businessPersonMapper) {

        this.rentalMapper = rentalMapper;
        this.businessPersonMapper = businessPersonMapper;
    }

    @Override
    public UserEntity dtoToEntity(User dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setFio( dto.getFio() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setPhoneNumber( dto.getPhoneNumber() );
        userEntity.setBusinessPerson( businessPersonMapper.dtoToEntity( dto.getBusinessPerson() ) );
        userEntity.setRentals( rentalMapper.toListEntity( dto.getRentals() ) );
        userEntity.setCredentialId( dto.getCredentialId() );

        return userEntity;
    }

    @Override
    public User entityToDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.fio( entity.getFio() );
        user.email( entity.getEmail() );
        user.phoneNumber( entity.getPhoneNumber() );
        user.rentals( rentalMapper.toList( entity.getRentals() ) );
        user.businessPerson( businessPersonMapper.entityToDto( entity.getBusinessPerson() ) );
        user.credentialId( entity.getCredentialId() );

        return user.build();
    }

    @Override
    public List<User> toList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( entityToDto( userEntity ) );
        }

        return list1;
    }

    @Override
    public List<UserEntity> toListEntity(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserEntity> list1 = new ArrayList<UserEntity>( list.size() );
        for ( User user : list ) {
            list1.add( dtoToEntity( user ) );
        }

        return list1;
    }
}
