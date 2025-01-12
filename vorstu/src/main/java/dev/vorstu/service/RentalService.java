package dev.vorstu.service;

import dev.vorstu.dto.Location;
import dev.vorstu.dto.Rental;
import dev.vorstu.dto.mapper.LocationMapper;
import dev.vorstu.dto.mapper.RentalMapper;
import dev.vorstu.repositories.LocationRepository;
import dev.vorstu.repositories.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

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
}
