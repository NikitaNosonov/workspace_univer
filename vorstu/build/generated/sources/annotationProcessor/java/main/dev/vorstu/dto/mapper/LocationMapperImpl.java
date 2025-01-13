package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Location;
import dev.vorstu.dto.PowerBank;
import dev.vorstu.dto.Rental;
import dev.vorstu.entity.LocationEntity;
import dev.vorstu.entity.PowerBankEntity;
import dev.vorstu.entity.RentalEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T15:21:36+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    private final PhotoMapper photoMapper;

    @Autowired
    public LocationMapperImpl(PhotoMapper photoMapper) {

        this.photoMapper = photoMapper;
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
        locationEntity.setOwnerPowerBanks( powerBankListToPowerBankEntityList( dto.getOwnerPowerBanks() ) );
        locationEntity.setPowerBanks( powerBankListToPowerBankEntityList( dto.getPowerBanks() ) );
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
        location.powerBanks( powerBankEntityListToPowerBankList( entity.getPowerBanks() ) );
        location.ownerPowerBanks( powerBankEntityListToPowerBankList( entity.getOwnerPowerBanks() ) );
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

    protected RentalEntity rentalToRentalEntity(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        RentalEntity rentalEntity = new RentalEntity();

        rentalEntity.setId( rental.getId() );
        rentalEntity.setStartTime( rental.getStartTime() );
        rentalEntity.setEndTime( rental.getEndTime() );
        rentalEntity.setPowerBankId( rental.getPowerBankId() );
        rentalEntity.setUserId( rental.getUserId() );

        return rentalEntity;
    }

    protected List<RentalEntity> rentalListToRentalEntityList(List<Rental> list) {
        if ( list == null ) {
            return null;
        }

        List<RentalEntity> list1 = new ArrayList<RentalEntity>( list.size() );
        for ( Rental rental : list ) {
            list1.add( rentalToRentalEntity( rental ) );
        }

        return list1;
    }

    protected PowerBankEntity powerBankToPowerBankEntity(PowerBank powerBank) {
        if ( powerBank == null ) {
            return null;
        }

        PowerBankEntity powerBankEntity = new PowerBankEntity();

        powerBankEntity.setId( powerBank.getId() );
        powerBankEntity.setType( powerBank.getType() );
        powerBankEntity.setCapacity( powerBank.getCapacity() );
        powerBankEntity.setCharge( powerBank.getCharge() );
        powerBankEntity.setStatusPowerBank( powerBank.isStatusPowerBank() );
        powerBankEntity.setRentals( rentalListToRentalEntityList( powerBank.getRentals() ) );
        powerBankEntity.setOwnerLocationId( powerBank.getOwnerLocationId() );
        powerBankEntity.setLocationPowerBankId( powerBank.getLocationPowerBankId() );

        return powerBankEntity;
    }

    protected List<PowerBankEntity> powerBankListToPowerBankEntityList(List<PowerBank> list) {
        if ( list == null ) {
            return null;
        }

        List<PowerBankEntity> list1 = new ArrayList<PowerBankEntity>( list.size() );
        for ( PowerBank powerBank : list ) {
            list1.add( powerBankToPowerBankEntity( powerBank ) );
        }

        return list1;
    }

    protected Rental rentalEntityToRental(RentalEntity rentalEntity) {
        if ( rentalEntity == null ) {
            return null;
        }

        Rental.RentalBuilder rental = Rental.builder();

        rental.id( rentalEntity.getId() );
        rental.powerBankId( rentalEntity.getPowerBankId() );
        rental.userId( rentalEntity.getUserId() );
        rental.startTime( rentalEntity.getStartTime() );
        rental.endTime( rentalEntity.getEndTime() );

        return rental.build();
    }

    protected List<Rental> rentalEntityListToRentalList(List<RentalEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Rental> list1 = new ArrayList<Rental>( list.size() );
        for ( RentalEntity rentalEntity : list ) {
            list1.add( rentalEntityToRental( rentalEntity ) );
        }

        return list1;
    }

    protected PowerBank powerBankEntityToPowerBank(PowerBankEntity powerBankEntity) {
        if ( powerBankEntity == null ) {
            return null;
        }

        PowerBank.PowerBankBuilder powerBank = PowerBank.builder();

        powerBank.id( powerBankEntity.getId() );
        powerBank.type( powerBankEntity.getType() );
        powerBank.capacity( powerBankEntity.getCapacity() );
        powerBank.charge( powerBankEntity.getCharge() );
        powerBank.statusPowerBank( powerBankEntity.isStatusPowerBank() );
        powerBank.ownerLocationId( powerBankEntity.getOwnerLocationId() );
        powerBank.locationPowerBankId( powerBankEntity.getLocationPowerBankId() );
        powerBank.rentals( rentalEntityListToRentalList( powerBankEntity.getRentals() ) );

        return powerBank.build();
    }

    protected List<PowerBank> powerBankEntityListToPowerBankList(List<PowerBankEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PowerBank> list1 = new ArrayList<PowerBank>( list.size() );
        for ( PowerBankEntity powerBankEntity : list ) {
            list1.add( powerBankEntityToPowerBank( powerBankEntity ) );
        }

        return list1;
    }
}
