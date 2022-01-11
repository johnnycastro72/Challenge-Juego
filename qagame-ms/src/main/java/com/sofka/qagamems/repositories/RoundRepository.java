package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoundRepository extends MongoRepository<Round, String> {
    List<Round> findByidCategory(String idCategory);
}
