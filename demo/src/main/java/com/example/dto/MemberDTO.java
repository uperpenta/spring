package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private long id;
    private Long LEI;
    private String legalName;
    private String description;
    private String adress;

    public long getId(){
        return id;
    }
}
