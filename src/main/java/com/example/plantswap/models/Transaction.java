package com.example.plantswap.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    private String buyExchange;

    @DBRef
    private User user;

    @DBRef
    private Plant plant;

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getBuyExchange() {
        return buyExchange;
    }

    public void setBuyExchange(String buyExchange) {
        this.buyExchange = buyExchange;
    }
}
