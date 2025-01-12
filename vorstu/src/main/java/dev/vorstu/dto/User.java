package dev.vorstu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String fio;
    private String email;
    private String phoneNumber;
    private List<Rental> rentals;
    private BusinessPerson businessPerson;
    private Long credentialId;
}

