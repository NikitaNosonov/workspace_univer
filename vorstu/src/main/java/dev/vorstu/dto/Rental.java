package dev.vorstu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    private Long id;
    private Long powerBankId;
    private Long userId;
    private Date startTime;
    private Date endTime;
}
