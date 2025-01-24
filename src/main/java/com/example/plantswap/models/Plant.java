package com.example.plantswap.models;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plants")
public class Plant {
    @Id
    private String id;

    @DBRef
    private User user;

    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Latin name can't be null")
    @NotEmpty(message = "Latin name can't be empty")
    private String latinName;

    @NotNull(message = "Size can't be null")
    @NotEmpty(message = "Size can't be empty")
    @Pattern(regexp = "S|M|H", message = "The alternatives can only be S (small), M (medium) or H (hard)")
    private String size;

    @NotNull(message = "Type can't be null")
    @NotEmpty(message = "Type can't be empty")
    private String type;

    @NotNull(message = "Light can't be null")
    @NotEmpty(message = "Light can't be empty")
    private String light;

    @NotNull(message = "Water can't be null")
    @NotEmpty(message = "Water can't be empty")
    private String water;

    @NotNull(message = "The price can't be null")
    @Min(value = 50, message = "The price can't be below 50 SEK")
    @Max(value = 1000, message = "The price can't be above 1000 SEK")
    private Double price;

    @NotNull(message = "Can't be null")
    @NotEmpty(message = "This can't be empty")
    @Pattern(regexp = "Buy|Exchange", message = "The alternatives can only be Buy or exchange")
    private String buyExchange;

    @NotNull(message = "Can't be null")
    @Min(value = 0, message = "The difficulty level can't be below 0")
    @Max(value = 5, message = "The difficulty level can't be above 5")
    private String difficultyLevel;

    @NotNull(message = "Status can't be null")
    @NotNull(message = "Status can't be empty")
    private String status;

    @NotNull(message = "Name can't be null")
    @NotNull(message = "Pictures can't be empty")
    private /*List<*/String pictures;

    public Plant() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull(message = "Name can't be null") @NotEmpty(message = "Name can't be empty") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name can't be null") @NotEmpty(message = "Name can't be empty") String name) {
        this.name = name;
    }

    public @NotNull(message = "Latin name can't be null") @NotEmpty(message = "Latin name can't be empty") String getLatinName() {
        return latinName;
    }

    public void setLatinName(@NotNull(message = "Latin name can't be null") @NotEmpty(message = "Latin name can't be empty") String latinName) {
        this.latinName = latinName;
    }

    public @NotNull(message = "Size can't be null") @NotEmpty(message = "Size can't be empty") @Pattern(regexp = "S|M|H", message = "The alternatives can only be S (small), M (medium) or H (hard)") String getSize() {
        return size;
    }

    public void setSize(@NotNull(message = "Size can't be null") @NotEmpty(message = "Size can't be empty") @Pattern(regexp = "S|M|H", message = "The alternatives can only be S (small), M (medium) or H (hard)") String size) {
        this.size = size;
    }

    public @NotNull(message = "Type can't be null") @NotEmpty(message = "Type can't be empty") String getType() {
        return type;
    }

    public void setType(@NotNull(message = "Type can't be null") @NotEmpty(message = "Type can't be empty") String type) {
        this.type = type;
    }

    public @NotNull(message = "Light can't be null") @NotEmpty(message = "Light can't be empty") String getLight() {
        return light;
    }

    public void setLight(@NotNull(message = "Light can't be null") @NotEmpty(message = "Light can't be empty") String light) {
        this.light = light;
    }

    public @NotNull(message = "Water can't be null") @NotEmpty(message = "Water can't be empty") String getWater() {
        return water;
    }

    public void setWater(@NotNull(message = "Water can't be null") @NotEmpty(message = "Water can't be empty") String water) {
        this.water = water;
    }

    public @NotNull(message = "The price can't be null") @Min(value = 50, message = "The price can't be below 50 SEK") @Max(value = 1000, message = "The price can't be above 1000 SEK") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "The price can't be null") @Min(value = 50, message = "The price can't be below 50 SEK") @Max(value = 1000, message = "The price can't be above 1000 SEK") Double price) {
        this.price = price;
    }

    public @NotNull(message = "Can't be null") @NotEmpty(message = "This can't be empty") @Pattern(regexp = "Buy|Exchange", message = "The alternatives can only be Buy or exchange") String getBuyExchange() {
        return buyExchange;
    }

    public void setBuyExchange(@NotNull(message = "Can't be null") @NotEmpty(message = "This can't be empty") @Pattern(regexp = "Buy|Exchange", message = "The alternatives can only be Buy or exchange") String buyExchange) {
        this.buyExchange = buyExchange;
    }

    public @NotNull(message = "Can't be null") @Min(value = 0, message = "The difficulty level can't be below 0") @Max(value = 5, message = "The difficulty level can't be above 5") String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(@NotNull(message = "Can't be null") @Min(value = 0, message = "The difficulty level can't be below 0") @Max(value = 5, message = "The difficulty level can't be above 5") String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public @NotNull(message = "Status can't be null") @NotNull(message = "Status can't be empty") String getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Status can't be null") @NotNull(message = "Status can't be empty") String status) {
        this.status = status;
    }

    public @NotNull(message = "Name can't be null") @NotNull(message = "Pictures can't be empty") String getPictures() {
        return pictures;
    }

    public void setPictures(@NotNull(message = "Name can't be null") @NotNull(message = "Pictures can't be empty") String pictures) {
        this.pictures = pictures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
