package com.example.plantswap.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    //använder denna för att jämföra emellan plant och den som vill köpa/byta
    private String buyExchange;

    @DBRef
    private User user;

    @DBRef
    private Plant plant;

    @DBRef
    private User buyerUser;

    @DBRef
    private Plant buyerPlant;

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

    public User getBuyerUser() {
        return buyerUser;
    }

    public void setBuyerUser(User buyerUser) {
        this.buyerUser = buyerUser;
    }

    public Plant getBuyerPlant() {
        return buyerPlant;
    }

    public void setBuyerPlant(Plant buyerPlant) {
        this.buyerPlant = buyerPlant;
    }
}
