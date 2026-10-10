package com.cg.money_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.money_tracker.dto.TransactionResponse;
import com.cg.money_tracker.entity.Transaction;
import com.cg.money_tracker.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/transaction")
    public TransactionResponse<Transaction> save(@RequestBody Transaction t) {
        return service.saveTransaction(t);
    }

    @GetMapping("/transaction/{id}")
    public TransactionResponse<Transaction> getById(@PathVariable int id) {
        return service.getTransaction(id);
    }

    @GetMapping("/transactions")
    public TransactionResponse<List<Transaction>> getAll() {
        return service.getAllTransaction();
    }

    @PutMapping("/transaction")
    public TransactionResponse<Transaction> update(@RequestBody Transaction t) {
        return service.updateTransaction(t);
    }

    @DeleteMapping("/transaction/{id}")
    public TransactionResponse<Transaction> deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/transactions")
    public TransactionResponse<List<Transaction>> deleteAll() {
        return service.deleteAll();
    }
}