package com.cg.money_tracker.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    private int id;
    private Double amount;
    private String category;
    private String description;
    private LocalDateTime transactionDateTime;
}
