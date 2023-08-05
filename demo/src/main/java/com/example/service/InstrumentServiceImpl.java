package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.dto.InstrumentDTO;
import com.example.entity.Instrument;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.InstrumentRepository;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentServiceImpl(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    private InstrumentDTO convertToDTO(Instrument instrument) {
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.setId(instrument.getId());
        instrumentDTO.setISIN(instrument.getISIN());
        instrumentDTO.setCurrency(instrument.getCurrency());
        instrumentDTO.setType(instrument.getType());
        instrumentDTO.setDescription(instrument.getDescription());
        instrumentDTO.setEffectiveDate(instrument.getEffectiveDate());
        instrumentDTO.setStatus(instrument.getStatus());
        return instrumentDTO;
    }

    private Instrument convertToEntity(InstrumentDTO instrumentDTO) {
        Instrument instrument = new Instrument();
        instrument.setId(instrumentDTO.getId());
        instrument.setISIN(instrumentDTO.getISIN());
        instrument.setCurrency(instrumentDTO.getCurrency());
        instrument.setType(instrumentDTO.getType());
        instrument.setDescription(instrumentDTO.getDescription());
        instrument.setEffectiveDate(instrumentDTO.getEffectiveDate());
        instrument.setStatus(instrumentDTO.getStatus());
        return instrument;
    }

    @Override
    public List<InstrumentDTO> getAllInstruments() {
        List<Instrument> instruments = instrumentRepository.findAll();
        return instruments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InstrumentDTO createInstrument(InstrumentDTO instrumentDTO) {
        Instrument instrumentRequest = convertToEntity(instrumentDTO);
        Instrument createdInstrument = instrumentRepository.save(instrumentRequest);
        return convertToDTO(createdInstrument);
    }

    @Override
    public InstrumentDTO updateInstrument(long id, InstrumentDTO instrumentDTO) {
        Instrument instrumentRequest = convertToEntity(instrumentDTO);
        Instrument instrument = instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instrument", "id", id));

        instrument.setISIN(instrumentRequest.getISIN());
        instrument.setCurrency(instrumentRequest.getCurrency());
        instrument.setType(instrumentRequest.getType());
        instrument.setDescription(instrumentRequest.getDescription());
        instrument.setEffectiveDate(instrumentRequest.getEffectiveDate());
        instrument.setStatus(instrumentRequest.getStatus());

        instrumentRepository.save(instrument);
        return convertToDTO(instrument);
    }

    @Override
    public void deleteInstrument(long id) {
        Instrument instrument = instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instrument", "id", id));

        instrumentRepository.delete(instrument);
    }

    public List<InstrumentDTO> getInstrumentById(long id) {
        Optional<Instrument> result = instrumentRepository.findById(id);
        if (result.isPresent()) {

            return result.stream().map(this::convertToDTO).collect(Collectors.toList());

        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }
    }
}
