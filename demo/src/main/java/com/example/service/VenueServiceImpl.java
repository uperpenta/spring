package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.repository.VenueRepository;
import com.example.entity.Venue;
import com.example.exception.ResourceNotFoundException;

@Service
public class VenueServiceImpl implements VenueService {
    
    @Autowired
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        super();
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenues(){
        return venueRepository.findAll();
    }

    @Override
    public Venue creatVenue(Venue venue){
        return venueRepository.save(venue);
    }

    @Override
    public Venue updateVenue(long id, Venue venueRequest){
        Venue venue=venueRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Venue","id", id));

        venue.setCity(venueRequest.getCity());
        venue.setCountry(venueRequest.getCountry());
        venue.setName(venueRequest.getName());

        return venueRepository.save(venue);
    }

    @Override
    public void deleteVenue(long id){
        Venue venue=venueRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Venue","id",id));

        venueRepository.delete(venue);
    }

    public Venue getVenueById(long id){
        Optional<Venue> result=venueRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new ResourceNotFoundException("Venue", "id", id);
        }

    }
    
}
