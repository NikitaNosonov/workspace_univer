package dev.vorstu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="businessPerson")
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

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @OneToMany(mappedBy = "businessPerson", fetch = FetchType.LAZY)
    private List<LocationEntity> locations;


}
