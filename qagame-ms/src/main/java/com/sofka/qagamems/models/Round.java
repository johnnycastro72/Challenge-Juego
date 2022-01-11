package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Round {
    @Id
    private String id;
    private Category idCategory;
    private Prize idPrize;

    public Round(Category idCategory, Prize idPrize) {
        this.idCategory = idCategory;
        this.idPrize = idPrize;
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

    public Prize getIdPrize() {
        return idPrize;
    }

    public void setIdPrize(Prize idPrize) {
        this.idPrize = idPrize;
    }
}
