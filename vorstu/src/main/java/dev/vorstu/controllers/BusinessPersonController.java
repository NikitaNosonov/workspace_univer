package dev.vorstu.controllers;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.dto.User;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.repositories.BusinessPersonRepository;
import dev.vorstu.service.BusinessPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessPerson> getBusinessPerson() {
        return businessPersonService.getBusinessPersons();
    }

    @GetMapping(value = "/businessPerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusinessPerson> getUserById(@PathVariable("id") Long id){
        Optional<BusinessPerson> businessPersonDto =businessPersonService.findById(id);
        return businessPersonDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
