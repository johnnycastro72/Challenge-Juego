package com.sofka.qagamems.controllers;

import com.sofka.qagamems.exceptions.PrizeNotFoundException;
import com.sofka.qagamems.models.Prize;
import com.sofka.qagamems.repositories.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PrizeController {

    @Autowired
    private final PrizeRepository prizeRepository;

    public PrizeController(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }

    @GetMapping("/prizes")
    public ResponseEntity<List<Prize>> getAllPrizes() {
        try {

            List<Prize> prizes = prizeRepository.findAll();

            if (prizes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(prizes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prizes/{id}")
    Prize getPrize(@PathVariable String id) {
        return prizeRepository.findById(id)
                .orElseThrow(() -> new PrizeNotFoundException("Prize NOT found"));
    }

    @PostMapping("/prizes")
    public ResponseEntity<Prize> createPrize(@RequestBody Prize prize) {
        try {
            Prize _prize = prizeRepository.save(new Prize(prize.getPrize(), prize.getValue()));
            return new ResponseEntity<>(_prize, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/prizes/{id}")
    public ResponseEntity<Prize> updatePrize(@PathVariable String id, @RequestBody Prize prize) {

        Optional<Prize> prizeData = prizeRepository.findById(id);

        if (prizeData.isPresent()) {
            Prize _prize = prizeData.get();
            _prize.setPrize(prize.getPrize());
            _prize.setValue(prize.getValue());
            return new ResponseEntity<>(prizeRepository.save(_prize), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/prizes/{id}")
    public ResponseEntity<HttpStatus> deletePrize(@PathVariable String id) {
        try {
            prizeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/prizes")
    public ResponseEntity<HttpStatus> deleteAllPrizes() {
        try {
            prizeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
