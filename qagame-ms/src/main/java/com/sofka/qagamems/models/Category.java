package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private String id;
    @Indexed(unique = true)
    private String Level;

    public Category(String id, String level) {
        this.id = id;
        Level = level;
    }

    public String getId() {
        return id;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }
}
