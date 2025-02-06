package dev.vorstu.controllers;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.dto.Location;
import dev.vorstu.dto.User;
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
    @GetMapping
    public List<Location> getLocation() {
        return locationService.getLocations();
    }

    @GetMapping(value = "/location/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id){
        Optional<Location> locationDto =locationService.findById(id);
        return locationDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Location changeLocation(@RequestBody Location changingLocation) {
        return locationService.update(changingLocation);
    }

    @DeleteMapping(value="/location/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteLocation(@PathVariable("id") Long id) {
        return locationService.delete(id);
    }
}
