package com.itau.challenge.API.controller;

import com.itau.challenge.API.model.Statistic;
import com.itau.challenge.API.model.Transaction;
import com.itau.challenge.API.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {
    private final TransactionRepository repository;

    public  StatisticController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Statistic> GetStatistic() {
        List<Transaction> transactions = repository.findAll().stream()
                .filter(item -> item.getDataHora() != null)
                .filter(item -> {
                    Instant dataHora = item.getDataHora().toInstant();
                    return dataHora.isAfter(Instant.now().minus(1, ChronoUnit.MINUTES)) && !dataHora.isAfter(Instant.now());
                })
                .toList();
        DoubleSummaryStatistics stats = transactions.stream().mapToDouble(Transaction::getValor).summaryStatistics();
        Statistic statistic = new Statistic(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());
        return ResponseEntity.ok(statistic);
    }
}
