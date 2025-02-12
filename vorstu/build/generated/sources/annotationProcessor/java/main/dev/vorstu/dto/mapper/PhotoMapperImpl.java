package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Photo;
import dev.vorstu.entity.PhotoEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T23:49:05+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public PhotoEntity dtoToEntity(Photo dto) {
        if ( dto == null ) {
            return null;
        }

        PhotoEntity photoEntity = new PhotoEntity();

        photoEntity.setId( dto.getId() );
        photoEntity.setPhotoPriority( dto.getPhotoPriority() );
        byte[] photo = dto.getPhoto();
        if ( photo != null ) {
            photoEntity.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        photoEntity.setLocationId( dto.getLocationId() );

        return photoEntity;
    }

    @Override
    public Photo entityToDto(PhotoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Photo.PhotoBuilder photo1 = Photo.builder();

        photo1.id( entity.getId() );
        photo1.photoPriority( entity.getPhotoPriority() );
        byte[] photo = entity.getPhoto();
        if ( photo != null ) {
            photo1.photo( Arrays.copyOf( photo, photo.length ) );
        }
        photo1.locationId( entity.getLocationId() );

        return photo1.build();
    }

    @Override
    public List<Photo> toList(List<PhotoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Photo> list1 = new ArrayList<Photo>( list.size() );
        for ( PhotoEntity photoEntity : list ) {
            list1.add( entityToDto( photoEntity ) );
        }

        return list1;
    }

    @Override
    public List<PhotoEntity> toListEntity(List<Photo> list) {
        if ( list == null ) {
            return null;
        }

        List<PhotoEntity> list1 = new ArrayList<PhotoEntity>( list.size() );
        for ( Photo photo : list ) {
            list1.add( dtoToEntity( photo ) );
        }

        return list1;
    }
}
