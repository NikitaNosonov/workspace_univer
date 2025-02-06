package dev.vorstu.service;

import dev.vorstu.dto.Location;
import dev.vorstu.dto.Rental;
import dev.vorstu.dto.mapper.LocationMapper;
import dev.vorstu.dto.mapper.RentalMapper;
import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.repositories.LocationRepository;
import dev.vorstu.repositories.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final CredentialService credentialService;

    public Rental create(Rental rental) {
        return rentalMapper.entityToDto(
                rentalRepository.save(rentalMapper.dtoToEntity(rental))
        );
    }

    public Rental update(Rental rental) {
        return rentalMapper.entityToDto(
                rentalRepository.save(rentalMapper.dtoToEntity(rental))
        );
    }

    public Long delete(Long id) {
        rentalRepository.deleteById(id);
        return id;
    }

    public List<Rental> getRentals() {
        return rentalMapper.toList(
                rentalRepository.findAll()
        );
    }

//    public List<Rental> findForCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            String currentUserName = authentication.getName();
//            CredentialEntity currentUser = credentialService.getByUsername(currentUserName);
//            Long businessPersonId = currentUser.getUserEntity().getBusinessPerson().getId();
//            return locationMapper.toList(locationRepository.findByBusinessPersonId(businessPersonId));
//        }
//        return Collections.emptyList();
//    }
}
