package dev.vorstu.dto.mapper;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.entity.BusinessPersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T04:14:00+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class BusinessPersonMapperImpl implements BusinessPersonMapper {

    private final LocationMapper locationMapper;

    @Autowired
    public BusinessPersonMapperImpl(LocationMapper locationMapper) {

        this.locationMapper = locationMapper;
    }

    @Override
    public BusinessPersonEntity dtoToEntity(BusinessPerson dto) {
        if ( dto == null ) {
            return null;
        }

        BusinessPersonEntity businessPersonEntity = new BusinessPersonEntity();

        businessPersonEntity.setId( dto.getId() );
        businessPersonEntity.setNameBusiness( dto.getNameBusiness() );
        businessPersonEntity.setIncome( dto.getIncome() );
        businessPersonEntity.setApplicationId( dto.getApplicationId() );
        businessPersonEntity.setApprovedApplication( dto.isApprovedApplication() );
        businessPersonEntity.setUserId( dto.getUserId() );
        businessPersonEntity.setLocations( locationMapper.toListEntity( dto.getLocations() ) );

        return businessPersonEntity;
    }

    @Override
    public BusinessPerson entityToDto(BusinessPersonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BusinessPerson.BusinessPersonBuilder businessPerson = BusinessPerson.builder();

        businessPerson.id( entity.getId() );
        businessPerson.nameBusiness( entity.getNameBusiness() );
        businessPerson.income( entity.getIncome() );
        businessPerson.locations( locationMapper.toList( entity.getLocations() ) );
        businessPerson.applicationId( entity.getApplicationId() );
        businessPerson.userId( entity.getUserId() );
        businessPerson.approvedApplication( entity.isApprovedApplication() );

        return businessPerson.build();
    }

    @Override
    public List<BusinessPerson> toList(List<BusinessPersonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BusinessPerson> list1 = new ArrayList<BusinessPerson>( list.size() );
        for ( BusinessPersonEntity businessPersonEntity : list ) {
            list1.add( entityToDto( businessPersonEntity ) );
        }

        return list1;
    }

    @Override
    public List<BusinessPersonEntity> toListEntity(List<BusinessPerson> list) {
        if ( list == null ) {
            return null;
        }

        List<BusinessPersonEntity> list1 = new ArrayList<BusinessPersonEntity>( list.size() );
        for ( BusinessPerson businessPerson : list ) {
            list1.add( dtoToEntity( businessPerson ) );
        }

        return list1;
    }
}
