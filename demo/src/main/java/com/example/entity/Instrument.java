package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long ISIN;
    private String currency;
    private String type;
    private String description;
    private String effectiveDate;
    private String status;


}
