package com.itau.challenge.API.controller;

import com.itau.challenge.API.DTO.TransactionRequest;
import com.itau.challenge.API.services.TransactionService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.itau.challenge.API.model.Transaction;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
  private final TransactionService service;

  public TransactionController(TransactionService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Void> create(@Valid @RequestBody TransactionRequest transaction) {
    if(transaction.getDataHora().isAfter(OffsetDateTime.now()))
    {
      return ResponseEntity.unprocessableEntity().build();
    }
    service.addTransaction(new Transaction(transaction.getValor(),  transaction.getDataHora()));
    return ResponseEntity.ok().build();
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public void delete() {
    service.clearTransactions();
  }
}