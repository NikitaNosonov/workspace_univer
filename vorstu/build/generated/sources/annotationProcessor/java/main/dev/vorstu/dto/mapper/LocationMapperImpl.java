package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Location;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.entity.LocationEntity;
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
public class LocationMapperImpl implements LocationMapper {

    private final PhotoMapper photoMapper;
    private final PowerBankMapper powerBankMapper;

    @Autowired
    public LocationMapperImpl(PhotoMapper photoMapper, PowerBankMapper powerBankMapper) {

        this.photoMapper = photoMapper;
        this.powerBankMapper = powerBankMapper;
    }

    @Override
    public LocationEntity dtoToEntity(Location dto) {
        if ( dto == null ) {
            return null;
        }

        LocationEntity locationEntity = new LocationEntity();

        locationEntity.setId( dto.getId() );
        locationEntity.setNameLocation( dto.getNameLocation() );
        locationEntity.setDescription( dto.getDescription() );
        locationEntity.setLatitude( dto.getLatitude() );
        locationEntity.setLongitude( dto.getLongitude() );
        locationEntity.setOwnerPowerBanks( powerBankMapper.toListEntity( dto.getOwnerPowerBanks() ) );
        locationEntity.setPowerBanks( powerBankMapper.toListEntity( dto.getPowerBanks() ) );
        locationEntity.setPhotos( photoMapper.toListEntity( dto.getPhotos() ) );
        locationEntity.setBusinessPersonId( dto.getBusinessPersonId() );

        return locationEntity;
    }

    @Override
    public Location entityToDto(LocationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Location.LocationBuilder location = Location.builder();

        location.id( entity.getId() );
        location.nameLocation( entity.getNameLocation() );
        location.description( entity.getDescription() );
        location.powerBanks( powerBankMapper.toList( entity.getPowerBanks() ) );
        location.ownerPowerBanks( powerBankMapper.toList( entity.getOwnerPowerBanks() ) );
        location.photos( photoMapper.toList( entity.getPhotos() ) );
        location.businessPersonId( entity.getBusinessPersonId() );
        location.latitude( entity.getLatitude() );
        location.longitude( entity.getLongitude() );

        return location.build();
    }

    @Override
    public List<Location> toList(List<LocationEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Location> list1 = new ArrayList<Location>( list.size() );
        for ( LocationEntity locationEntity : list ) {
            list1.add( entityToDto( locationEntity ) );
        }

        return list1;
    }

    @Override
    public List<LocationEntity> toListEntity(List<Location> list) {
        if ( list == null ) {
            return null;
        }

        List<LocationEntity> list1 = new ArrayList<LocationEntity>( list.size() );
        for ( Location location : list ) {
            list1.add( dtoToEntity( location ) );
        }

        return list1;
    }

    @Override
    public BusinessPersonEntity toBusinessPersonEntity(Long businessPersonId) {
        if ( businessPersonId == null ) {
            return null;
        }

        BusinessPersonEntity businessPersonEntity = new BusinessPersonEntity();

        return businessPersonEntity;
    }
}
