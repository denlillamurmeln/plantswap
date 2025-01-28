package com.example.plantswap.repositories;

import com.example.plantswap.models.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlantRepository extends MongoRepository<Plant, String> {
    List<Plant> findByStatus(String status);

    List<Plant> findByUser(String id);

    //List<Plant> findByPlantId(String plantId);
}
