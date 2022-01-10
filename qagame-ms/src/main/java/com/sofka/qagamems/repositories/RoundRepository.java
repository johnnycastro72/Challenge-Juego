package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoundRepository extends MongoRepository<Round, String> {
}
