package dev.vorstu.repositories;

import dev.vorstu.entity.credential.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
    Optional<CredentialEntity> findByUsername(String username);
}

