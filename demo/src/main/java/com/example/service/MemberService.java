package com.example.service;

import java.util.List;

import com.example.dto.MemberDTO;


public interface MemberService {
    List<MemberDTO> getAllMembers();

    MemberDTO createMember(MemberDTO memberDTO);

    MemberDTO updateMember(long id, MemberDTO memberDTO);

    void deleteMember(long id);

    List<MemberDTO> getMemberById(long id);

}
