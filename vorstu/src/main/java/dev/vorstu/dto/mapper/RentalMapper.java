package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Rental;
import dev.vorstu.entity.RentalEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class,
                PowerBankMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RentalMapper {
    RentalEntity dtoToEntity(Rental dto);

    Rental entityToDto(RentalEntity entity);

    List<Rental> toList(List<RentalEntity> list);

    List<RentalEntity> toListEntity(List<Rental> list);
}
