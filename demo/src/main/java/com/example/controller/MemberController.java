package com.example.controller;

import java.util.List;

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
import com.example.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MemberDTO>> getMemberById(@PathVariable(name = "id") long id) {
        List<MemberDTO> member = memberService.getMemberById(id);
        
        return ResponseEntity.ok().body(member);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) {
        MemberDTO createdMember=memberService.createMember(memberDTO);
        return new ResponseEntity<MemberDTO>(createdMember, HttpStatus.CREATED);
 
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable long id, @RequestBody MemberDTO memberDTO) {

        MemberDTO member = memberService.updateMember(id, memberDTO);

        return ResponseEntity.ok().body(member);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable(name = "id") long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member with id" + id + " has been deleted.");
    }

}
