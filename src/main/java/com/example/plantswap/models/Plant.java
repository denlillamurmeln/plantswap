package com.example.plantswap.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "plants")
public class Plant {
    @Id
    private String id;
    private String name;
    private String latinName;
    private String size;
    private String type;
    private String light;
    private String water;
    private String buyExchange;
    private String difficultyLevel;
    private String status;
    private List<String> pictures;

}
