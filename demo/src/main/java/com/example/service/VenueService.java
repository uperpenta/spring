package com.example.service;

import java.util.List;

import com.example.entity.Venue;

public interface VenueService {
    List<Venue> getAllVenues();

    Venue creatVenue(Venue venue);

    Venue updateVenue(long id, Venue venue);

    void deleteVenue(long id);

    Venue getVenueById(long id);
}
