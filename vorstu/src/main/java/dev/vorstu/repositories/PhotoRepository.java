package dev.vorstu.repositories;

import dev.vorstu.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
    List<PhotoEntity> findAll();
}
