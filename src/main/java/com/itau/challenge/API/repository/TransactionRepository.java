package com.itau.challenge.API.repository;

import com.itau.challenge.API.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
  private final List<Transaction> transactions = new ArrayList<>();

  public void save(Transaction transaction) {
    transactions.add(transaction);
  }

  public List<Transaction> findAll() {
    return new ArrayList<>(transactions);
  }

  public void deleteAll() {
    transactions.clear();
  }
}