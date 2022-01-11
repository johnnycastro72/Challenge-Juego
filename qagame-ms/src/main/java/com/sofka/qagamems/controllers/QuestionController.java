package com.sofka.qagamems.controllers;

import com.sofka.qagamems.exceptions.QuestionNotFoundException;
import com.sofka.qagamems.models.Question;
import com.sofka.qagamems.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionRepository.findAll();

            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/questions/{id}")
    Question getQuestion(@PathVariable String id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question NOT Found"));
    }

    @GetMapping("/questions/category/{idCategory}")
    public ResponseEntity<List<Question>> findByidCategory(@PathVariable String idCategory) {
        try {
            List<Question> categories = questionRepository.findByidCategory(idCategory);

            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@PathVariable Question question) {
        try {
            Question _question = questionRepository.save(new Question(question.getIdCategory(), question.getQuestion(), question.getOptions()));
            return new ResponseEntity<>(_question, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable String id, @RequestBody Question question) {

        Optional<Question> questionData = questionRepository.findById(id);

        if (questionData.isPresent()) {
            Question _question = questionData.get();
            _question.setQuestion(question.getQuestion());
            _question.setIdCategory(question.getIdCategory());
            _question.setOptions(question.getOptions());
            return new ResponseEntity<>(questionRepository.save(_question), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable String id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/questions")
    public ResponseEntity<HttpStatus> deleteAllQuestions() {
        try {
            questionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
