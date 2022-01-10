package com.sofka.qagamems.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Prize {
    @Id
    private String id;
    private String prize;
    private int value;

    public Prize(String id, String prize, int value) {
        this.id = id;
        this.prize = prize;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
