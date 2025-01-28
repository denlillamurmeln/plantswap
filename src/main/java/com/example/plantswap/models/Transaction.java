package com.example.plantswap.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

//    @PositiveOrZero(message = "Price can't be a negative number")
//    @Positive(message = "Price must be greater than 0")
//    private Integer add;
//
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

//    public Integer getAdd() {
//        return add;
//    }
//
//    public void setAdd(Integer add) {
//        this.add = add;
//    }
//
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
