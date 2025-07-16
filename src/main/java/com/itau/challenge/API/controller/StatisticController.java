package com.itau.challenge.API.controller;

import com.itau.challenge.API.DTO.StatisticsResponse;
import com.itau.challenge.API.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/estatistica")
public class StatisticController {
    private final TransactionService service;

    public StatisticController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StatisticsResponse> GetStatistic() {
        return ResponseEntity.ok(new StatisticsResponse((service.getStatistics())));
    }
}
