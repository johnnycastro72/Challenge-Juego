package com.sofka.qagamems.controllers;

import com.sofka.qagamems.exceptions.RecordNotFoundException;
import com.sofka.qagamems.models.Question;
import com.sofka.qagamems.models.Record;
import com.sofka.qagamems.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RecordController {

    @Autowired
    private final RecordRepository recordRepository;

    public RecordController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping("/records")
    public ResponseEntity<List<Record>> getAllRecords() {
        try {
            List<Record> records = recordRepository.findAll();

            if (records.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(records, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/records/{id}")
    Record getRecord(@PathVariable String id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record NOT Found"));
    }

    @GetMapping("/records/status/{idStatus}")
    public ResponseEntity<List<Record>> findByidStatus(@PathVariable String idStatus) {
        try {
            List<Record> records = recordRepository.findByidStatus(idStatus);

            if (records.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(records, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/records")
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        try {
            Record _record = recordRepository.save(new Record(record.getUser(), record.getDate(), record.getIdRound(), record.getIdQuestion(), record.getIdStatus()));
            return new ResponseEntity<>(_record, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/records/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable String id, @RequestBody Record record) {

        Optional<Record> recordData = recordRepository.findById(id);

        if (recordData.isPresent()) {
            Record _record = recordData.get();
            _record.setDate(record.getDate());
            _record.setIdQuestion(record.getIdQuestion());
            _record.setIdRound(record.getIdRound());
            _record.setIdStatus(record.getIdStatus());
            _record.setUser(record.getUser());
            return new ResponseEntity<>(recordRepository.save(_record), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/records/{id}")
    public ResponseEntity<HttpStatus> deleteRecord(@PathVariable String id) {
        try {
            recordRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/records")
    public ResponseEntity<HttpStatus> feleteAllRecords() {
        try {
            recordRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
