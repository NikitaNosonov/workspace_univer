package dev.vorstu.repositories;

import dev.vorstu.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    List<LocationEntity> findAll();
}
