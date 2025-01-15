package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Location;
import dev.vorstu.dto.Photo;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.entity.LocationEntity;
import dev.vorstu.entity.PhotoEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {PhotoMapper.class,
                BusinessPersonMapper.class,
                PowerBankMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LocationMapper {
    LocationEntity dtoToEntity(Location dto);

    Location entityToDto(LocationEntity entity);

    List<Location> toList(List<LocationEntity> list);

    List<LocationEntity> toListEntity(List<Location> list);

    BusinessPersonEntity toBusinessPersonEntity(Long businessPersonId);
}
