package com.itau.challenge.API.model;

import java.time.OffsetDateTime;
import java.util.Date;

public class Transaction {
  private double valor;
  private OffsetDateTime dataHora;

  public Transaction(double valor, OffsetDateTime dataHora) {
    this.valor = valor;
    this.dataHora = dataHora;
  }
  public double getValor() {
    return valor;
  }
  public OffsetDateTime getDataHora() {
    return dataHora;
  }
}