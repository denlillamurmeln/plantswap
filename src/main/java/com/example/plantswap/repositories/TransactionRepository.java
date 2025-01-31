package com.example.plantswap.repositories;

import com.example.plantswap.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUserId(String id);

    //List<Transaction> findByUserIdAndPlantId(String userId, String plantId);


//    List<Transaction> findByUser(User user);
//
//    List<Transaction> getAllAdsForUser(User user);
}
