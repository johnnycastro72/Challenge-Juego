package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByCategory(String idCategory);
}
