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
public class BusinessPerson {
    private Long id;
    private String nameBusiness;
    private String income;
    private List<Location> locations;
    private Long applicationId;
    private Long userId;
    private boolean approvedApplication;
}
