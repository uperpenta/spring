package com.example.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private Long id;
    private String LEI;
    private String legalName;
    private String description;
    private String adress;
}
