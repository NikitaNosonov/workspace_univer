package dev.vorstu.service;

import dev.vorstu.dto.Location;
import dev.vorstu.dto.mapper.LocationMapper;
import dev.vorstu.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public Location create(Location location) {
        return locationMapper.entityToDto(
                locationRepository.save(locationMapper.dtoToEntity(location))
        );
    }

    public Location update(Location location) {
        return locationMapper.entityToDto(
                locationRepository.save(locationMapper.dtoToEntity(location))
        );
    }

    public Long delete(Long id) {
        locationRepository.deleteById(id);
        return id;
    }

    public List<Location> getLocations() {
        return locationMapper.toList(
                locationRepository.findAll()
        );
    }
}
