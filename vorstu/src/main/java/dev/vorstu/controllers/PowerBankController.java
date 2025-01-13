package dev.vorstu.controllers;

import dev.vorstu.dto.PowerBank;
import dev.vorstu.entity.PowerBankEntity;
import dev.vorstu.repositories.PowerBankRepository;
import dev.vorstu.service.PowerBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/powerBank")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class PowerBankController {

    @Autowired
    private PowerBankRepository powerBankRepository;
    private final PowerBankService powerBankService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PowerBank createPowerBank(@RequestBody PowerBank newPowerBank) {
        return powerBankService.create(newPowerBank);
    }

//    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public PowerBank changePowerBank(@RequestBody PowerBank changingPowerBank) {
//        return powerBankService.update(changingPowerBank);
//    }
//
//    @DeleteMapping(value="powerBanks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Long deletePowerBank(@PathVariable("id") Long id) {
//        return powerBankService.delete(id);
//    }

    @GetMapping(value = "powerBanks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PowerBankEntity> getAllPowerBanks() {
        return powerBankRepository.findAll();
    }

    @GetMapping("/powerBank/{id}")
    public PowerBankEntity getPowerBankById(@PathVariable Long id) {
        return powerBankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Повербанк не найден с ID: " + id));
    }
}
