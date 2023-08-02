package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDTO {
    private long id;
    private long ISIN;
    private String currency;
    private String type;
    private String description;
    private String effectiveDate;
    private String status;
}
