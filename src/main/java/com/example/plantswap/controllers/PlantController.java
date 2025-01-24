package com.example.plantswap.controllers;

import com.example.plantswap.models.Plant;
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
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
//        // om author fylls i - kolla att den finns i db
//        if(plant.getUser() != null && !userRepository.existsById(plant.getUser().getId())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
//        }

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

        Plant updatedPlant = plantRepository.save(existingPlant);
        return ResponseEntity.ok(updatedPlant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable String id) {
        if (!plantRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found");
        }
        plantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
