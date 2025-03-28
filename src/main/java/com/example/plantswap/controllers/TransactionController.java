package com.example.plantswap.controllers;

import com.example.plantswap.models.Plant;
import com.example.plantswap.models.Transaction;
import com.example.plantswap.models.User;
import com.example.plantswap.repositories.PlantRepository;
import com.example.plantswap.repositories.TransactionRepository;
import com.example.plantswap.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final PlantRepository plantRepository;

    public TransactionController(UserRepository userRepository, TransactionRepository transactionRepository, PlantRepository plantRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.plantRepository = plantRepository;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        User user = userRepository.findById(transaction.getUser().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Plant plant = plantRepository.findById(transaction.getPlant().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));

        User buyerUser = userRepository.findById(transaction.getBuyerUser().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));


        //gjorde såhär för att få min if-sats att funka
        String exchange = "exchange";
        String buy = "buy";
        String available = "available";

        //kollar så min plant går att byta, min andra user har en plant och om status är available
        if (exchange.equals(transaction.getBuyExchange())) {

            Plant buyerPlant = plantRepository.findById(transaction.getBuyerPlant().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));

            if (!exchange.equals(plant.getBuyExchange()) || !available.equals(plant.getStatus())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The plant is not available for exchange");
            }
            plant.setBuyExchange("exchanged");
            plant.setStatus("not available");

            if (!exchange.equals(buyerPlant.getBuyExchange()) || !available.equals(buyerPlant.getStatus())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The plant is not available for exchange");
            }
            buyerPlant.setBuyExchange("exchanged");
            buyerPlant.setStatus("not available");
        }

        //kollar så min plant går att köpa och om status är available
        if (buy.equals(transaction.getBuyExchange())) {
            if (!buy.equals(plant.getBuyExchange()) || !available.equals(plant.getStatus())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The plant is not available for buying");
            }
            plant.setBuyExchange("bought");
            plant.setStatus("sold");
        }

        transaction.setUser(user);
        transaction.setPlant(plant);

        if (buyerUser != null) {
            transaction.setBuyerUser(buyerUser);
        }

        //transaction.setBuyerPlant(buyerPlant);

        Transaction savedTransaction = transactionRepository.save(transaction);
        plantRepository.save(plant);
        //plantRepository.save(buyerPlant);

        return ResponseEntity.ok(savedTransaction);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String id, @RequestBody Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));

        if (transaction.getBuyExchange() != null) {
            existingTransaction.setBuyExchange(transaction.getBuyExchange());
        }

        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        }

        transactionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Transaction>> getUserTransaction(@PathVariable String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        List<Transaction> transactions = transactionRepository.findByUserId(user.getId());

        if (transactions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No transactions found for this user");
        }

        return ResponseEntity.ok(transactions);
    }

}
