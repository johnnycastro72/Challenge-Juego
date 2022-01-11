package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Question {
    @Id
    private String id;
    private Category idCategory;
    private String squestion;
    private List<Option> options;

    public Question(Category idCategory, String squestion, List<Option> options) {
        this.idCategory = idCategory;
        this.squestion = squestion;
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public String getsQuestion() {
        return squestion;
    }

    public void setsQuestion(String squestion) {
        this.squestion = squestion;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
