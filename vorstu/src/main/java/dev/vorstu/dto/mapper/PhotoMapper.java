package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Photo;
import dev.vorstu.entity.PhotoEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {LocationMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PhotoMapper {
    PhotoEntity dtoToEntity(Photo dto);

    Photo entityToDto(PhotoEntity entity);

    List<Photo> toList(List<PhotoEntity> list);

    List<PhotoEntity> toListEntity(List<Photo> list);
}
