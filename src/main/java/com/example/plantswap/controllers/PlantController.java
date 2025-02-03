package com.example.plantswap.controllers;

import com.example.plantswap.models.Plant;
import com.example.plantswap.models.User;
import com.example.plantswap.repositories.PlantRepository;
import com.example.plantswap.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    public PlantController(PlantRepository plantRepository, UserRepository userRepository) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant, User user) {
//        // om author fylls i - kolla att den finns i db
//        if(plant.getUser() != null && !userRepository.existsById(plant.getUser().getId())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
//        }
        //plant.setUser(user);

        Plant savedPlant = plantRepository.save(plant);
        //return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
        return ResponseEntity.ok(savedPlant);
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        return ResponseEntity.ok(plants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable String id) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Plant not found"));
        return ResponseEntity.ok(plant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable String id, @RequestBody Plant plant) {
        Plant existingPlant = plantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found."));

        if (plant.getName() != null) {
            existingPlant.setName(plant.getName());
        }

        if (plant.getLatinName() != null) {
            existingPlant.setLatinName(plant.getLatinName());
        }

        if (plant.getSize() != null) {
            existingPlant.setSize(plant.getSize());
        }

        if (plant.getType() != null) {
            existingPlant.setType(plant.getType());
        }

        if (plant.getLight() != null) {
            existingPlant.setLight(plant.getLight());
        }

        if (plant.getWater() != null) {
            existingPlant.setWater(plant.getWater());
        }

        if (plant.getPrice() != null) {
            existingPlant.setPrice(plant.getPrice());
        }

        if (plant.getBuyExchange() != null) {
            existingPlant.setBuyExchange(plant.getBuyExchange());
        }

        if (plant.getDifficultyLevel() != null) {
            existingPlant.setDifficultyLevel(plant.getDifficultyLevel());
        }

        if (plant.getStatus() != null) {
            existingPlant.setStatus(plant.getStatus());
        }

        if (plant.getPictures() != null) {
            existingPlant.setPictures(plant.getPictures());
        }

        if (plant.getUser() != null) {
            User user = userRepository.findById(plant.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "User not found"
                    ));
            existingPlant.setUser(user);
        }

        Plant updatedPlant = plantRepository.save(existingPlant);
        return ResponseEntity.ok(updatedPlant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable String id) {
        if (!plantRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found");
        }
        plantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{available}")
    public ResponseEntity<List<Plant>> getPlantsByAvailable(@PathVariable String available) {
        List<Plant> plants = plantRepository.findByStatus(available);
        return ResponseEntity.ok(plants);
    }



}
