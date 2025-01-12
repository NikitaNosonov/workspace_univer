package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Location;
import dev.vorstu.entity.LocationEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {PhotoMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LocationMapper {
    LocationEntity dtoToEntity(Location dto);

    Location entityToDto(LocationEntity entity);

    List<Location> toList(List<LocationEntity> list);

}
