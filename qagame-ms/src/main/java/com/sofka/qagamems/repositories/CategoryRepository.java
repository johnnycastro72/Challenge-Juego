package com.sofka.qagamems.repositories;

import com.sofka.qagamems.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
