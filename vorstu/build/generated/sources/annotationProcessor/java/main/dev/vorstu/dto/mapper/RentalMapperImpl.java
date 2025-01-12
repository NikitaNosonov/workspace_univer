package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Rental;
import dev.vorstu.entity.RentalEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T21:32:54+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class RentalMapperImpl implements RentalMapper {

    @Override
    public RentalEntity dtoToEntity(Rental dto) {
        if ( dto == null ) {
            return null;
        }

        RentalEntity rentalEntity = new RentalEntity();

        rentalEntity.setId( dto.getId() );
        rentalEntity.setStartTime( dto.getStartTime() );
        rentalEntity.setEndTime( dto.getEndTime() );

        return rentalEntity;
    }

    @Override
    public Rental entityToDto(RentalEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Rental.RentalBuilder rental = Rental.builder();

        rental.id( entity.getId() );
        rental.startTime( entity.getStartTime() );
        rental.endTime( entity.getEndTime() );

        return rental.build();
    }

    @Override
    public List<Rental> toList(List<RentalEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Rental> list1 = new ArrayList<Rental>( list.size() );
        for ( RentalEntity rentalEntity : list ) {
            list1.add( entityToDto( rentalEntity ) );
        }

        return list1;
    }

    @Override
    public List<RentalEntity> toListEntity(List<Rental> list) {
        if ( list == null ) {
            return null;
        }

        List<RentalEntity> list1 = new ArrayList<RentalEntity>( list.size() );
        for ( Rental rental : list ) {
            list1.add( dtoToEntity( rental ) );
        }

        return list1;
    }
}