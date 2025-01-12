package dev.vorstu.dto.mapper;

import dev.vorstu.dto.PowerBank;
import dev.vorstu.entity.PowerBankEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {RentalMapper.class,
                LocationMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PowerBankMapper {
    PowerBankEntity dtoToEntity(PowerBank dto);

    PowerBank entityToDto(PowerBankEntity entity);

    List<PowerBank> toList(List<PowerBankEntity> list);

    List<PowerBankEntity> toListEntity(List<PowerBank> list);
}
