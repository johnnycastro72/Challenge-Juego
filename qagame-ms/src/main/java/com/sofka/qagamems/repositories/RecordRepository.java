package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, String> {
}
