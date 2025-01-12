package dev.vorstu.service.auth;

import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CredentialEntity credential = credentialRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + credential.getRole().name());

        return new org.springframework.security.core.userdetails.User(credential.getUsername(),
                credential.getPassword(),
                Collections.singletonList(authority));
    }
}