package dev.vorstu.controllers;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.dto.Location;
import dev.vorstu.entity.LocationEntity;
import dev.vorstu.repositories.LocationRepository;
import dev.vorstu.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getBusinessPerson() {
        return locationService.getLocations();
    }
}
