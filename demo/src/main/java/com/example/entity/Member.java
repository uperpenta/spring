package com.example.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long LEI;
    private String legalName;
    private String description;
    private String adress;
    
    @JoinColumn(name="venue_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venue venue;



}
