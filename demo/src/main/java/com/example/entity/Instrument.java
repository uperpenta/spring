package com.example.entity;

import java.sql.Date;

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
    private String ISIN;
    private String currency;
    private String type;
    private String description;
    private Date effectiveDate;
    private String status;


}
