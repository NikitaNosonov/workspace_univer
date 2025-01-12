package dev.vorstu.repositories;

import dev.vorstu.entity.PowerBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerBankRepository extends JpaRepository<PowerBankEntity, Long> {
    List<PowerBankEntity> findAll();
}
