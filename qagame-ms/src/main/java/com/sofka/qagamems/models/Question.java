package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Question {
    @Id
    private String id;
    private Category idCategory;
    private String question;
    private List<Option> options;

    public Question(String id, Category idCategory, String question, List<Option> options) {
        this.id = id;
        this.idCategory = idCategory;
        this.question = question;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
