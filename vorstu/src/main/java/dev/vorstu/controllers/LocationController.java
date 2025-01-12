package dev.vorstu.controllers;

import dev.vorstu.dto.Location;
import dev.vorstu.entity.LocationEntity;
import dev.vorstu.repositories.LocationRepository;
import dev.vorstu.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/location")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
    private final LocationService locationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Location createLocation(@RequestBody Location newLocation) {
        return locationService.create(newLocation);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Location changeLocation(@RequestBody Location changingLocation) {
        return locationService.update(changingLocation);
    }

    @DeleteMapping(value="locations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteLocation(@PathVariable("id") Long id) {
        return locationService.delete(id);
    }

    @GetMapping(value = "/locations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/location/{id}")
    public LocationEntity getLocationById(@PathVariable Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Локация не найдена с ID: " + id));
    }
}
