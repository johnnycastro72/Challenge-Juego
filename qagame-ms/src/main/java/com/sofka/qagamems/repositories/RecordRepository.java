package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecordRepository extends MongoRepository<Record, String> {
    List<Record> findByidStatus(String idStatus);
}
