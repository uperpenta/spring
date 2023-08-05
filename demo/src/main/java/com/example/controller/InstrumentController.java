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

import com.example.dto.InstrumentDTO;
import com.example.service.InstrumentService;


@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public List<InstrumentDTO> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<InstrumentDTO>> getInstrumentById(@PathVariable(name = "id") long id) {
        List<InstrumentDTO> instrument = instrumentService.getInstrumentById(id);
        return ResponseEntity.ok(instrument);
    }

    @PostMapping
    public ResponseEntity<InstrumentDTO> createInstrument(@RequestBody InstrumentDTO instrumentDTO) {
        InstrumentDTO createdInstrument = instrumentService.createInstrument(instrumentDTO);
        return new ResponseEntity<>(createdInstrument, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentDTO> updateInstrument(@PathVariable long id, @RequestBody InstrumentDTO instrumentDTO) {
        InstrumentDTO updatedInstrument = instrumentService.updateInstrument(id, instrumentDTO);
        return ResponseEntity.ok(updatedInstrument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstrument(@PathVariable(name = "id") long id) {
        instrumentService.deleteInstrument(id);
        return ResponseEntity.ok("Instrument with id " + id + " has been deleted.");

    }
}
