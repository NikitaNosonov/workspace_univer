package dev.vorstu.repositories;

import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusinessPersonRepository extends JpaRepository<BusinessPersonEntity, Long> {
    List<BusinessPersonEntity> findAll();
    Optional<BusinessPersonEntity> findByUserId(Long userId);
}
