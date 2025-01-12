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
public class Location {
    private Long id;
    private String nameLocation;
    private String description;
    private List<PowerBank> powerBanks;
    private List<PowerBank> ownerPowerBanks;
    private List<Photo> photos;
    private Long businessPersonId;
    private double latitude;
    private double longitude;
}
