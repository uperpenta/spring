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


import com.example.dto.VenueDTO;
import com.example.entity.Venue;
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

        VenueDTO venueResponse = modelMapper.map(venue, VenueDTO.class);

        return ResponseEntity.ok().body(venueResponse);
    }

    @PostMapping
    public ResponseEntity<VenueDTO> createVenue(@RequestBody VenueDTO venueDTO) {

        Venue venueRequest = modelMapper.map(venueDTO, Venue.class);
   
        Venue venue = venueService.createVenue(venueRequest);
        
        VenueDTO venueResponse = modelMapper.map(venue, VenueDTO.class);
        
        return new ResponseEntity<VenueDTO>(venueResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> updateVenue(@PathVariable long id, @RequestBody VenueDTO venueDTO) {

        Venue venueRequest = modelMapper.map(venueDTO, Venue.class);

        Venue venue = venueService.updateVenue(id, venueRequest);

        VenueDTO venueResponse = modelMapper.map(venue, VenueDTO.class);

        return ResponseEntity.ok().body(venueResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenue(@PathVariable(name = "id") long id) {
        venueService.deleteVenue(id);
        return ResponseEntity.ok("Venue with id" + id + " has been deleted.");
    }

    
}
