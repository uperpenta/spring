package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.repository.VenueRepository;
import com.example.dto.VenueDTO;
import com.example.entity.Venue;
import com.example.exception.ResourceNotFoundException;

@Service
public class VenueServiceImpl implements VenueService {
    
    @Autowired
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    private VenueDTO convertToDTO(Venue venue) {
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setCity(venue.getCity());
        venueDTO.setCountry(venue.getCountry());
        venueDTO.setName(venue.getName());
        venueDTO.setId(venue.getId());
        return venueDTO;
    }

    @Override
    public List<VenueDTO> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venues.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public VenueDTO createVenue(VenueDTO venueDTO) {
        Venue venueRequest = convertToEntity(venueDTO);
        Venue createdVenue = venueRepository.save(venueRequest);
        return convertToDTO(createdVenue);
    }

    @Override
    public VenueDTO updateVenue(long id, VenueDTO venueDTO) {
        Venue venueRequest = convertToEntity(venueDTO);
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue", "id", id));

        venue.setCity(venueRequest.getCity());
        venue.setCountry(venueRequest.getCountry());
        venue.setName(venueRequest.getName());

        Venue updatedVenue = venueRepository.save(venue);
        return convertToDTO(updatedVenue);
    }

    @Override
    public void deleteVenue(long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue", "id", id));

        venueRepository.delete(venue);
    }

    public List<VenueDTO> getVenueById(long id) {
   Optional<Venue> result = venueRepository.findById(id);
        if (result.isPresent()) {

            return result.stream().map(this::convertToDTO).collect(Collectors.toList());

        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }
    }
    

    private Venue convertToEntity(VenueDTO venueDTO) {
        Venue venue = new Venue();
        venue.setCity(venueDTO.getCity());
        venue.setCountry(venueDTO.getCountry());
        venue.setName(venueDTO.getName());
        venue.setId(venueDTO.getId());
        return venue;
    }
}
