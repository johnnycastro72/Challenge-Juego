package com.sofka.qagamems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private String id;
    private String level;

    public Category() { }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Category(String level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", level=" + level + "]";
    }

}
