    package dev.vorstu.dto.auth;

    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class JwtResponse {
        private String token;
        private Long userId;
    }
