package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Option {
    @Id
    private String id;
    private String answer;
    private Boolean correct;

    public Option(String answer, Boolean correct) {
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

    @Override
    public String toString() {
        return "Option [id=" + id + ", answer=" + answer + ", correct=" + correct.toString() + "]";
    }

}
