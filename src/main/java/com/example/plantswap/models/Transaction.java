package com.example.plantswap.models;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    @PositiveOrZero(message = "Price can't be a negative number")
    @Positive(message = "Price must be greater than 0")
    private Double totalPrice;

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

    public @PositiveOrZero(message = "Price can't be a negative number") @Positive(message = "Price must be greater than 0") Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@PositiveOrZero(message = "Price can't be a negative number") @Positive(message = "Price must be greater than 0") Double totalPrice) {
        this.totalPrice = totalPrice;
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
}
