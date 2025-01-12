package dev.vorstu.repositories;

import dev.vorstu.entity.BusinessPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessPersonRepository extends JpaRepository<BusinessPersonEntity, Long> {
    List<BusinessPersonEntity> findAll();
}
