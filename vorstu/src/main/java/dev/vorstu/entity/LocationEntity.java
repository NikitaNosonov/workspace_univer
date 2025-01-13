package dev.vorstu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="locations")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameLocation;
    private String description;
    private double latitude;
    private double longitude;

    @OneToMany (mappedBy = "ownerLocation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PowerBankEntity> ownerPowerBanks;

    @OneToMany (mappedBy = "locationPowerBank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PowerBankEntity> powerBanks;

    @OneToMany (mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PhotoEntity> photos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessPerson_id", nullable = false, updatable = false, insertable = false)
    private BusinessPersonEntity businessPerson;

    @Column(name="businessPerson_id")
    private Long businessPersonId;
}
