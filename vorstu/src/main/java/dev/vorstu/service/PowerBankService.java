package dev.vorstu.service;

import dev.vorstu.dto.PowerBank;
import dev.vorstu.dto.mapper.PowerBankMapper;
import dev.vorstu.repositories.PowerBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class PowerBankService {
    private final PowerBankRepository powerBankRepository;
    private final PowerBankMapper powerBankMapper;

    public PowerBank create(PowerBank powerBank) {
        return powerBankMapper.entityToDto(
                powerBankRepository.save(powerBankMapper.dtoToEntity(powerBank))
        );
    }

    public PowerBank update(PowerBank powerBank) {
        return powerBankMapper.entityToDto(
                powerBankRepository.save(powerBankMapper.dtoToEntity(powerBank))
        );
    }

    public Long delete(Long id) {
        powerBankRepository.deleteById(id);
        return id;
    }

    public List<PowerBank> getPowerBanks() {
        return powerBankMapper.toList(
                powerBankRepository.findAll()
        );
    }
}
