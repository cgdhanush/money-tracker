package com.cg.money_tracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.money_tracker.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }
}
