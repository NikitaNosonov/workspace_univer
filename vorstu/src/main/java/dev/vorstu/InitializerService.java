package dev.vorstu;

import dev.vorstu.dto.User;
import dev.vorstu.dto.credential.Credential;
import dev.vorstu.dto.credential.Role;
import dev.vorstu.service.BusinessPersonService;
import dev.vorstu.service.CredentialService;
import dev.vorstu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitializerService {
    @Lazy
    @Autowired
    private final CredentialService credentialService;
    @Lazy
    @Autowired
    private final UserService userService;
    @Lazy
    @Autowired
    private final BusinessPersonService businessPersonService;

    public void initial() {
        Credential credential = credentialService.create(Credential.builder()
                .username("user")
                .password("1111")
                .role(Role.USER)
                .build());

        Credential credential1 = credentialService.create(Credential.builder()
                .username("admin")
                .password("1111")
                .role(Role.ADMIN)
                .build());

        Credential credential2 = credentialService.create(Credential.builder()
                .username("user1")
                .password("1111")
                .role(Role.USER)
                .build());

        User userId = userService.create(User.builder()
                .fio("Иванов Иван Иванович")
                .email("i1@mail.ru")
                .phoneNumber("11122233377")
                .credentialId(credential.getId())
                .build());

        User userId1 = userService.create(User.builder()
                .fio("Алексеев Алекей Алексеевич")
                .email("i1@mail.ru")
                .phoneNumber("11122233377")
                .credentialId(credential2.getId())
                .build());
    }
}
