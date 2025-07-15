package com.itau.challenge.API.controller;

import com.itau.challenge.API.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.itau.challenge.API.model.Transaction;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
  private final TransactionRepository repository;

  public TransactionController(TransactionRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Transaction transaction) {
    repository.save(transaction);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public void delete() {
    repository.deleteAll();
  }
}