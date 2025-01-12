package dev.vorstu.service;

import dev.vorstu.dto.Photo;
import dev.vorstu.dto.mapper.PhotoMapper;
import dev.vorstu.repositories.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    public Photo create(Photo photo) {
        return photoMapper.entityToDto(
                photoRepository.save(photoMapper.dtoToEntity(photo))
        );
    }

    public Photo update(Photo photo) {
        return photoMapper.entityToDto(
                photoRepository.save(photoMapper.dtoToEntity(photo))
        );
    }

    public Long delete(Long id) {
        photoRepository.deleteById(id);
        return id;
    }

    public List<Photo> getPhotos() {
        return photoMapper.toList(
                photoRepository.findAll()
        );
    }

}
