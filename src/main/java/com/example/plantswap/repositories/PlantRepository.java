package com.example.plantswap.repositories;

import com.example.plantswap.models.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlantRepository extends MongoRepository<Plant, String> {
    List<Plant> findByStatus(String status);

    List<Plant> findByUserId(String id);

    //List<Plant> findByUserIdAndPlantId(String userId, String plantId);

    //List<Plant> findByPlantId(String plantId);
}
