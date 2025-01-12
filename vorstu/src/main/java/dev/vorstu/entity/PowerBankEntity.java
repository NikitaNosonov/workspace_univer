package dev.vorstu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="powerBanks")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerBankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Integer capacity;
    private Integer charge;
    private boolean statusPowerBank;

    @OneToMany(mappedBy = "powerBank", fetch = FetchType.LAZY)
    private List<RentalEntity> rentals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_location_id", nullable = false)
    private LocationEntity ownerLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_power_bank_id", nullable = false)
    private LocationEntity locationPowerBank;
}
