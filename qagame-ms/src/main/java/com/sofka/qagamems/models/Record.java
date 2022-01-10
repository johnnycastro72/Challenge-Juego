package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Record {
    @Id
    private String id;
    private String user;
    private Date date;
    private Round idRound;
    private Question idQuestion;
    private Status idStatus;

    public Record(String id, String user, Date date, Round idRound, Question idQuestion, Status idStatus) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.idRound = idRound;
        this.idQuestion = idQuestion;
        this.idStatus = idStatus;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Round getIdRound() {
        return idRound;
    }

    public void setIdRound(Round idRound) {
        this.idRound = idRound;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }
}
