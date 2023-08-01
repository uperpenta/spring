package com.example.service;

import java.util.List;

import com.example.entity.Member;



public interface MemberService {
    List<Member> getAllMembers();

    Member createMember(Member member);

    Member updateMember(long id, Member member);

    void deleteMember(long id);

    Member getMemberById(long id);

}
