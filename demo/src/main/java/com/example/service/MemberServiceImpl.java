package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.repository.MemberRepository;
import com.example.repository.VenueRepository;
import com.example.dto.MemberDTO;
import com.example.entity.Member;
import com.example.exception.ResourceNotFoundException;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final VenueRepository venueRepository;

   

    public MemberServiceImpl(MemberRepository memberRepository, VenueRepository venueRepository) {
        super();
        this.memberRepository = memberRepository;
        this.venueRepository = venueRepository;
    }

    private MemberDTO convertToDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setAdress(member.getAdress());
        memberDTO.setDescription(member.getDescription());
        memberDTO.setLEI(member.getLEI());
        memberDTO.setLegalName(member.getLegalName());
        memberDTO.setId(member.getId());
        memberDTO.setVenueId(member.getVenue().getId());
        return memberDTO;

    }

    private Member convertToEntity(MemberDTO memberDTO){
        Member member = new Member();
        member.setAdress(memberDTO.getAdress());
        member.setDescription(memberDTO.getDescription());
        member.setLEI(memberDTO.getLEI());
        member.setLegalName(memberDTO.getLegalName());
        member.setId(memberDTO.getId());
        member.setVenue(venueRepository.findById(memberDTO.getVenueId()).orElseThrow(RuntimeException::new));
        return member;
    }


    @Override
    public List<MemberDTO> getAllMembers() {
        List<Member> members=memberRepository.findAll();
        return members.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    @Override
    public MemberDTO createMember(MemberDTO memberDTO) {
        
        Member memberRequest = convertToEntity(memberDTO);

        Member createdMember= memberRepository.save(memberRequest);

        return convertToDTO(createdMember);
    }

    @Override
    public MemberDTO updateMember(long id, MemberDTO memberDTO) {
        Member memberRequest =convertToEntity(memberDTO);
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));

        member.setAdress(memberRequest.getAdress());
        member.setDescription(memberRequest.getDescription());
        member.setLEI(memberRequest.getLEI());
        member.setLegalName(memberRequest.getLegalName());
        

        memberRepository.save(member);

        return convertToDTO(member);

    }

    @Override
    public void deleteMember(long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));

        memberRepository.delete(member);

    }

    public List<MemberDTO> getMemberById(long id) {


        Optional<Member> result = memberRepository.findById(id);
        if (result.isPresent()) {

            return result.stream().map(this::convertToDTO).collect(Collectors.toList());

        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }
    }

 
}
