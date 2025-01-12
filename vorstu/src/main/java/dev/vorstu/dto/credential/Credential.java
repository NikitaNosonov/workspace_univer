package dev.vorstu.dto.credential;

import dev.vorstu.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credential {
    private Long id;
    private String password;
    private String username;
    private Role role;
    private User user;
}
