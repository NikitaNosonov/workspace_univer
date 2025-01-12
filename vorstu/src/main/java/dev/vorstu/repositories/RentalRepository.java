package dev.vorstu.repositories;

import dev.vorstu.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
    List<RentalEntity> findAll();
}
