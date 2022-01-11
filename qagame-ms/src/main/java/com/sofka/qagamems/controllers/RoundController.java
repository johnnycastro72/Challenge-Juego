package com.sofka.qagamems.controllers;

import com.sofka.qagamems.exceptions.RoundNotFoundException;
import com.sofka.qagamems.models.Question;
import com.sofka.qagamems.models.Round;
import com.sofka.qagamems.repositories.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RoundController {

    @Autowired
    private final RoundRepository roundRepository;

    public RoundController(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    @GetMapping("/rounds")
    public ResponseEntity<List<Round>> getAllRounds() {
        try {
            List<Round> rounds = roundRepository.findAll();

            if (rounds.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(rounds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rounds/{id}")
    Round getRound(@PathVariable String id) {
        return roundRepository.findById(id)
                .orElseThrow(() -> new RoundNotFoundException("Round NOT Found"));
    }

    @GetMapping("/rounds/category/{idCategory}")
    public ResponseEntity<List<Round>> findByCategory(@PathVariable String idCategory) {
        try {
            List<Round> rounds = roundRepository.findByCategory(idCategory);

            if (rounds.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rounds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rounds")
    public ResponseEntity<Round> createRound(@RequestBody Round round) {
        try {
            Round _round = roundRepository.save(new Round(round.getIdCategory(), round.getPrizes()));
            return new ResponseEntity<>(_round, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/rounds/{id}")
    public ResponseEntity<Round> updateRound(@PathVariable String id, @RequestBody Round round) {

        Optional<Round> roundData = roundRepository.findById(id);

        if (roundData.isPresent()) {
            Round _round = roundData.get();
            _round.setIdCategory(round.getIdCategory());
            _round.setPrizes(round.getPrizes());
            return new ResponseEntity<>(roundRepository.save(_round), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/rounds/{id}")
    public ResponseEntity<HttpStatus> deleteRound(@PathVariable String id) {
        try {
            roundRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/rounds")
    public ResponseEntity<HttpStatus> deleteAllRounds() {
        try {
            roundRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
