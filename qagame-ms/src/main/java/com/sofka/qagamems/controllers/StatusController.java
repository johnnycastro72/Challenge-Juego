package com.sofka.qagamems.controllers;

import com.sofka.qagamems.exceptions.StatusNotFoundException;
import com.sofka.qagamems.models.Status;
import com.sofka.qagamems.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

    @Autowired
    private final StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/status")
    public ResponseEntity<List<Status>> getAllStatus() {
        try {
            List<Status> status = statusRepository.findAll();

            if (status.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/status/{id}")
    Status getStatus(@PathVariable String id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new StatusNotFoundException("Status NOT Found"));
    }

    @PostMapping("/status")
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        try {
            Status _status = statusRepository.save(new Status(status.getStatus()));
            return new ResponseEntity<>(_status, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable String id, @RequestBody Status status) {

        Optional<Status> statusData = statusRepository.findById(id);

        if (statusData.isPresent()) {
            Status _status = statusData.get();
            _status.setStatus(status.getStatus());
            return new ResponseEntity<>(statusRepository.save(_status), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<HttpStatus> deleteStatus(@PathVariable String id) {
        try {
            statusRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/status")
    public ResponseEntity<HttpStatus> deleteAllStatus() {
        try {
            statusRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
