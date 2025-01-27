package com.example.plantswap.repositories;

import com.example.plantswap.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    //List<User> findByUser(String id);
}
