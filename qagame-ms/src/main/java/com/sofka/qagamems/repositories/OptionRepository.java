package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OptionRepository extends MongoRepository<Option, String> {
}
