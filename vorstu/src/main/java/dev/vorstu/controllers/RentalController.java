package dev.vorstu.controllers;

import dev.vorstu.dto.Rental;
import dev.vorstu.entity.RentalEntity;
import dev.vorstu.repositories.RentalRepository;
import dev.vorstu.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class RentalController {

    @Autowired
    private RentalRepository rentalRepository;
    private final RentalService rentalService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Rental createRental(@RequestBody Rental newRental) {
        return rentalService.create(newRental);
    }

//    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public Rental changeRental(@RequestBody Rental changingRental) {
//        return rentalService.update(changingRental);
//    }
//
//    @DeleteMapping(value="rentals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Long deleteRental(@PathVariable("id") Long id) {
//        return rentalService.delete(id);
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentalEntity> getAllRentals() {
        return rentalRepository.findAll();
    }

    @GetMapping(value = "/rental/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentalEntity getRentalById(@PathVariable Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Аредна не найдена с ID: " + id));
    }
}
