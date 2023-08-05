package com.example.service;

import java.util.List;

import com.example.dto.InstrumentDTO;

public interface InstrumentService {
    List<InstrumentDTO> getAllInstruments();

    InstrumentDTO createInstrument(InstrumentDTO instrumentDTO);

    InstrumentDTO updateInstrument(long id, InstrumentDTO instrumentDTO);

    void deleteInstrument(long id);

    List<InstrumentDTO> getInstrumentById(long id);
}
