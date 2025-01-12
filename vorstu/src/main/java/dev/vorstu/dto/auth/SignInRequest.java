package dev.vorstu.dto.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignInRequest {
    private String username;
    private String password;
}
