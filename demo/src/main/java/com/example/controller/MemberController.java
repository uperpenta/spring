package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberDTO;
import com.example.entity.Member;
import com.example.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final ModelMapper modelMapper;

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        super();
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers().stream().map(member -> modelMapper.map(member, MemberDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable(name = "id") long id) {
        Member member = memberService.getMemberById(id);

        MemberDTO memberResponse = modelMapper.map(member, MemberDTO.class);

        return ResponseEntity.ok().body(memberResponse);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) {

        Member memberRequest = modelMapper.map(memberDTO, Member.class);
        System.out.println(memberRequest);
        Member member = memberService.createMember(memberRequest);
        System.out.println(member);
        MemberDTO memberResponse = modelMapper.map(member, MemberDTO.class);
        System.out.println(memberResponse);
        return new ResponseEntity<MemberDTO>(memberResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable long id, @RequestBody MemberDTO memberDTO) {

        Member memberRequest = modelMapper.map(memberDTO, Member.class);

        Member member = memberService.updateMember(id, memberRequest);

        MemberDTO memberResponse = modelMapper.map(member, MemberDTO.class);

        return ResponseEntity.ok().body(memberResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable(name = "id") long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member with id" + id + " has been deleted.");
    }

}
