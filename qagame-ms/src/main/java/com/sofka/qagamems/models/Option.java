package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Option {
    @Id
    private String id;
    private String answer;
    private Boolean correct;

    public Option(String id, String answer, Boolean correct) {
        this.id = id;
        this.answer = answer;
        this.correct = correct;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
