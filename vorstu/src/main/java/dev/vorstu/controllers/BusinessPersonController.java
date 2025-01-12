package dev.vorstu.controllers;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.repositories.BusinessPersonRepository;
import dev.vorstu.service.BusinessPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/businessPerson")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class BusinessPersonController {

    @Autowired
    private BusinessPersonRepository businessPersonRepository;
    private final BusinessPersonService businessPersonService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessPerson createBusinessPerson(@RequestBody BusinessPerson newBusinessPerson) {
        return businessPersonService.create(newBusinessPerson);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessPerson changeBusinessPerson(@RequestBody BusinessPerson changingBusinessPerson) {
        return businessPersonService.update(changingBusinessPerson);
    }

    @DeleteMapping(value="businessPersons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteBusinessPerson(@PathVariable("id") Long id) {
        return businessPersonService.delete(id);
    }

    @GetMapping(value = "businessPersons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessPersonEntity> getAllBusinessPersons() {
        return businessPersonRepository.findAll();
    }

    @GetMapping("/businessPerson/{id}")
    public BusinessPersonEntity getBusinessPersonById(@PathVariable Long id) {
        return businessPersonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Предприниматель не найден с ID: " + id));
    }
}
