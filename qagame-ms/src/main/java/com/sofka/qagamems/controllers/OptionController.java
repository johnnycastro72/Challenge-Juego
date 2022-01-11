package com.sofka.qagamems.controllers;

import com.sofka.qagamems.exceptions.OptionNotFoundException;
import com.sofka.qagamems.models.Option;
import com.sofka.qagamems.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OptionController {

    @Autowired
    private final OptionRepository optionRepository;

    public OptionController(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @GetMapping("/options")
    public ResponseEntity<List<Option>> getAllOptions() {
        try {
            List<Option> options = optionRepository.findAll();

            if (options.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(options, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("options/{id}")
    Option getOption(@PathVariable String id) {
        return optionRepository.findById(id)
                .orElseThrow(() -> new OptionNotFoundException("Option NOT found"));
    }

    @PostMapping("/options")
    public ResponseEntity<Option> createOption(@RequestBody Option option) {
        try {
            Option _option = optionRepository.save(new Option(option.getAnswer(), option.getCorrect()));
            return new ResponseEntity<>(_option, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/options/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable String id, @RequestBody Option option) {

        Optional<Option> optionData = optionRepository.findById(id);

        if (optionData.isPresent()) {
            Option _option = optionData.get();
            _option.setAnswer(option.getAnswer());
            _option.setCorrect(option.getCorrect());
            return new ResponseEntity<>(optionRepository.save(_option), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/options/{id}")
    public ResponseEntity<HttpStatus> deleteOption(@PathVariable String id) {
        try {
            optionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/options")
    public ResponseEntity<HttpStatus> deleteAllOptions() {
        try {
            optionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
