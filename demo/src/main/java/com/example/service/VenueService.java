package com.example.service;

import java.util.List;

import com.example.dto.VenueDTO;

public interface VenueService {
    List<VenueDTO> getAllVenues();

    VenueDTO createVenue(VenueDTO venueDTO);

    VenueDTO updateVenue(long id, VenueDTO venueDTO);

    void deleteVenue(long id);

    List<VenueDTO> getVenueById(long id);
}
