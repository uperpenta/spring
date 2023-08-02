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
import com.example.dto.VenueDTO;
import com.example.entity.Member;
import com.example.service.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    

    private final ModelMapper modelMapper;

    private final VenueService venueService;

    @Autowired
    public VenueController(ModelMapper modelMapper, VenueService venueService) {
        super();
        this.modelMapper = modelMapper;
        this.venueService = venueService;
    }

    @GetMapping
    public List<VenueDTO> getAllVenues() {
        return venueService.getAllVenues().stream().map(venue -> modelMapper.map(venue, VenueDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable(name = "id") long id) {
        Venue venue = venueService.getVenueById(id);

        MemberDTO memberResponse = modelMapper.map(member, MemberDTO.class);

        return ResponseEntity.ok().body(memberResponse);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) {

        Member memberRequest = modelMapper.map(memberDTO, Member.class);
   
        Member member = memberService.createMember(memberRequest);
        
        MemberDTO memberResponse = modelMapper.map(member, MemberDTO.class);
        
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
