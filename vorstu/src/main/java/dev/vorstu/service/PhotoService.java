package dev.vorstu.service;

import dev.vorstu.dto.Photo;
import dev.vorstu.dto.mapper.PhotoMapper;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.entity.LocationEntity;
import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.repositories.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;
    private final CredentialService credentialService;

    public Photo create(Photo photo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            CredentialEntity currentUser = credentialService.getByUsername(currentUserName);

            BusinessPersonEntity businessPersonEntity = currentUser.getUserEntity().getBusinessPerson();

            List<LocationEntity> locations = businessPersonEntity.getLocations();
        }

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
