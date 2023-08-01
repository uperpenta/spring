package com.example.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Issuer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long LEI;
    private String legalName;
    private String description;

}
