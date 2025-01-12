package dev.vorstu.entity;

import dev.vorstu.entity.credential.CredentialEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;
    private String email;
    private String phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "businessPerson_id")
    private BusinessPersonEntity businessPerson;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RentalEntity> rentals;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id", unique = true)
    private CredentialEntity credential;
}
