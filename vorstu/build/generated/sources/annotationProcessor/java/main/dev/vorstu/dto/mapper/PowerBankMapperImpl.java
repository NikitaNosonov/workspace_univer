package dev.vorstu.dto.mapper;

import dev.vorstu.dto.PowerBank;
import dev.vorstu.entity.PowerBankEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T15:44:37+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class PowerBankMapperImpl implements PowerBankMapper {

    private final RentalMapper rentalMapper;

    @Autowired
    public PowerBankMapperImpl(RentalMapper rentalMapper) {

        this.rentalMapper = rentalMapper;
    }

    @Override
    public PowerBankEntity dtoToEntity(PowerBank dto) {
        if ( dto == null ) {
            return null;
        }

        PowerBankEntity powerBankEntity = new PowerBankEntity();

        powerBankEntity.setId( dto.getId() );
        powerBankEntity.setType( dto.getType() );
        powerBankEntity.setCapacity( dto.getCapacity() );
        powerBankEntity.setCharge( dto.getCharge() );
        powerBankEntity.setStatusPowerBank( dto.isStatusPowerBank() );
        powerBankEntity.setRentals( rentalMapper.toListEntity( dto.getRentals() ) );
        powerBankEntity.setOwnerLocationId( dto.getOwnerLocationId() );
        powerBankEntity.setLocationPowerBankId( dto.getLocationPowerBankId() );

        return powerBankEntity;
    }

    @Override
    public PowerBank entityToDto(PowerBankEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PowerBank.PowerBankBuilder powerBank = PowerBank.builder();

        powerBank.id( entity.getId() );
        powerBank.type( entity.getType() );
        powerBank.capacity( entity.getCapacity() );
        powerBank.charge( entity.getCharge() );
        powerBank.statusPowerBank( entity.isStatusPowerBank() );
        powerBank.ownerLocationId( entity.getOwnerLocationId() );
        powerBank.locationPowerBankId( entity.getLocationPowerBankId() );
        powerBank.rentals( rentalMapper.toList( entity.getRentals() ) );

        return powerBank.build();
    }

    @Override
    public List<PowerBank> toList(List<PowerBankEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PowerBank> list1 = new ArrayList<PowerBank>( list.size() );
        for ( PowerBankEntity powerBankEntity : list ) {
            list1.add( entityToDto( powerBankEntity ) );
        }

        return list1;
    }

    @Override
    public List<PowerBankEntity> toListEntity(List<PowerBank> list) {
        if ( list == null ) {
            return null;
        }

        List<PowerBankEntity> list1 = new ArrayList<PowerBankEntity>( list.size() );
        for ( PowerBank powerBank : list ) {
            list1.add( dtoToEntity( powerBank ) );
        }

        return list1;
    }
}
