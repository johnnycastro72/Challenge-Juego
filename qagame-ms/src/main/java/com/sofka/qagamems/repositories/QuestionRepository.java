package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
