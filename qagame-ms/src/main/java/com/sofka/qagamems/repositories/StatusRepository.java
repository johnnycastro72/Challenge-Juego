package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatusRepository extends MongoRepository<Status, String> {
}
