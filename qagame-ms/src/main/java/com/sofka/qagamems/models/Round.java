package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Round {
    @Id
    private String id;
    private Category idCategory;
    private List<Prize> prizes;

    public Round(Category idCategory, List<Prize> prizes) {
        this.idCategory = idCategory;
        this.prizes = prizes;
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

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }
}
