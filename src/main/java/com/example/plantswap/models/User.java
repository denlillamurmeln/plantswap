package com.example.plantswap.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotNull(message = "User name can't be null")
    @NotEmpty(message = "User name can't be empty")
    private String username;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull(message = "User name can't be null") @NotEmpty(message = "User name can't be empty") String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(message = "User name can't be null") @NotEmpty(message = "User name can't be empty") String username) {
        this.username = username;
    }
}
