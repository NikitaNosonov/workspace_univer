package dev.vorstu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="businessPersons")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameBusiness;
    private String income;
    private Long applicationId;
    private boolean approvedApplication;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "businessPerson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LocationEntity> locations;
}