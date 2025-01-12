package dev.vorstu.service;

import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.dto.mapper.BusinessPersonMapper;
import dev.vorstu.repositories.BusinessPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class BusinessPersonService {
    private final BusinessPersonRepository businessPersonRepository;
    private final BusinessPersonMapper businessPersonMapper;

    public BusinessPerson create(BusinessPerson businessPerson) {
        return businessPersonMapper.entityToDto(
                businessPersonRepository.save(businessPersonMapper.dtoToEntity(businessPerson))
        );
    }

    public BusinessPerson update(BusinessPerson businessPerson) {
        return businessPersonMapper.entityToDto(
                businessPersonRepository.save(businessPersonMapper.dtoToEntity(businessPerson))
        );
    }

    public Long delete(Long id) {
        businessPersonRepository.deleteById(id);
        return id;
    }

    public List<BusinessPerson> getLocations() {
        return businessPersonMapper.toList(
                businessPersonRepository.findAll()
        );
    }
}
