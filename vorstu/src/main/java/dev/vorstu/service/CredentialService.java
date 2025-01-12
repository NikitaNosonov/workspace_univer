package dev.vorstu.service;

import dev.vorstu.dto.credential.Credential;
import dev.vorstu.dto.mapper.CredentialMapper;
import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.repositories.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class CredentialService {
    private final CredentialRepository credentialRepository;
    private final CredentialMapper mapper;
    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Credential create(Credential credentialDto) {
        credentialDto.setPassword(passwordEncoder.encode(credentialDto.getPassword()));
        return mapper.entityToDto(credentialRepository.save(mapper.dtoToEntity(credentialDto)));
    }

    public Credential update(Credential credentialDto) {
        return mapper.entityToDto(credentialRepository.save(mapper.dtoToEntity(credentialDto)));
    }

    public Long delete(Long id) {
        credentialRepository.deleteById(id);
        return id;
    }

    public List<Credential> findAll() {
        return mapper.toList(credentialRepository.findAll());
    }

    public CredentialEntity getByUsername(String username) {
        return credentialRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public CredentialEntity getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}
