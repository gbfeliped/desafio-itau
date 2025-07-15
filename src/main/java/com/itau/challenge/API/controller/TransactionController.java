package com.itau.challenge.API.controller;

import com.itau.challenge.API.Repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.itau.challenge.API.model.Transaction;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
  private final TransactionRepository transactionRepository = new TransactionRepository();

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createTransaction(@RequestBody Transaction transaction) {
    transactionRepository.save(transaction);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public void deleteTransaction() {
    transactionRepository.deleteAll();
  }
}