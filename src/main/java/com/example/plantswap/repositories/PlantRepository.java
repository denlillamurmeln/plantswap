package com.example.plantswap.repositories;

import com.example.plantswap.models.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantRepository extends MongoRepository<Plant, String> {
}
