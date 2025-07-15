package com.itau.challenge.API.model;

import java.util.Date;

public class Transaction {
  private double valor;
  private Date dataHora;

  public Transaction(double valor, Date dataHora) {
    if (dataHora == null) {
      throw new IllegalArgumentException("dataHora não pode ser nula.");
    }
    if (valor < 0) {
      throw new IllegalArgumentException("valor não pode ser negativo.");
    }
    Date agora = new Date();
    if (dataHora.after(agora)) {
      throw new IllegalArgumentException("dataHora não pode ser no futuro.");
    }
    this.valor = valor;
    this.dataHora = dataHora;
  }
  public double getValor() {
    return valor;
  }
  public Date getDataHora() {
    return dataHora;
  }
}