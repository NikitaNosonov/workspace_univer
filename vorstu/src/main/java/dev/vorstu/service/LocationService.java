package dev.vorstu.service;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.dto.Location;
import dev.vorstu.dto.mapper.LocationMapper;
import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final CredentialService credentialService;

    public Location create(Location location) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            CredentialEntity currentUser = credentialService.getByUsername(currentUserName);
            location.setBusinessPersonId(currentUser.getUserEntity().getBusinessPerson().getId());
        }
        return locationMapper.entityToDto(
                locationRepository.save(locationMapper.dtoToEntity(location))
        );
    }

    public Location update(Location location) {
        return locationMapper.entityToDto(
                locationRepository.save(locationMapper.dtoToEntity(location))
        );
    }

    public List<Location> getLocations() {
        return locationMapper.toList(
                locationRepository.findAll()
        );
    }

    public Long delete(Long id) {
        locationRepository.deleteById(id);
        return id;
    }

    public List<Location> findLocations() {
        return locationMapper.toList(
                locationRepository.findAll());
    }

    public List<Location> findForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            CredentialEntity currentUser = credentialService.getByUsername(currentUserName);
            Long businessPersonId = currentUser.getUserEntity().getBusinessPerson().getId();
            return locationMapper.toList(locationRepository.findByBusinessPersonId(businessPersonId));
        }
        return Collections.emptyList();
    }
}
