package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.repository.MemberRepository;
import com.example.entity.Member;
import com.example.exception.ResourceNotFoundException;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    
    public MemberServiceImpl(MemberRepository memberRepository){
        super();
        this.memberRepository=memberRepository;
    }
    
    @Override
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @Override
    public Member createMember(Member member) {
            return memberRepository.save(member);
    }

    @Override
    public Member updateMember(long id, Member memberRequest){
        Member member=memberRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Member","id",id));

        member.setAdress(memberRequest.getAdress());
        member.setDescription(memberRequest.getDescription());
        //member.setId(memberRequest.getId());
        member.setLEI(memberRequest.getLEI());
        member.setLegalName(memberRequest.getLegalName());

        return memberRepository.save(member);

    }
    
    @Override
    public void deleteMember(long id)
    {
        Member member = memberRepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("Member", "id", id));
        
        memberRepository.delete(member);
        
    }

    public Member getMemberById(long id){
        Optional<Member> result = memberRepository.findById(id);
        if(result.isPresent()) {
            return result.get();

        }else {
            throw new ResourceNotFoundException("member", "id", id);
        }
    }
    

    
}
