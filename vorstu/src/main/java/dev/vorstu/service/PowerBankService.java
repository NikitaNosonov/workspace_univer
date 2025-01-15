package dev.vorstu.service;

import dev.vorstu.dto.Location;
import dev.vorstu.dto.PowerBank;
import dev.vorstu.dto.mapper.PowerBankMapper;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.entity.LocationEntity;
import dev.vorstu.entity.PowerBankEntity;
import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.repositories.PowerBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class PowerBankService {
    private final PowerBankRepository powerBankRepository;
    private final PowerBankMapper powerBankMapper;
    private final CredentialService credentialService;

    public PowerBank create(PowerBank powerBank) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            CredentialEntity currentUser = credentialService.getByUsername(currentUserName);

            BusinessPersonEntity businessPersonEntity = currentUser.getUserEntity().getBusinessPerson();

            List<LocationEntity> locations = businessPersonEntity.getLocations();

            if (!locations.isEmpty()) {
                LocationEntity location = locations.get(0);
                powerBank.setOwnerLocationId(location.getId());
            } else {
                throw new IllegalArgumentException("No available locations for the current business person.");
            }
        }

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

    public Optional<PowerBank> findById(Long id) {
        PowerBankEntity powerBankEntity = powerBankRepository.findById(id).orElse(null);
        if (powerBankEntity != null) {
            return Optional.of(powerBankMapper.entityToDto(powerBankEntity));
        } else {
            return Optional.empty();
        }
    }
}
