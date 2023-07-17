package com.example.echo.aluguel.model;


import java.time.LocalDate;

public class ProcessaCobrancasEmFila {
    private int id;
    private Cobranca cobranca;
    private String status;
    private LocalDate horaSolicitadada;
    private LocalDate horaFinalizada;
    private double valor;
    private  int ciclista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getHoraSolicitadada() {
        return horaSolicitadada;
    }

    public void setHoraSolicitadada(LocalDate horaSolicitadada) {
        this.horaSolicitadada = horaSolicitadada;
    }

    public LocalDate getHoraFinalizada() {
        return horaFinalizada;
    }

    public void setHoraFinalizada(LocalDate horaFinalizada) {
        this.horaFinalizada = horaFinalizada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCiclista() {
        return ciclista;
    }

    public void setCiclista(int ciclista) {
        this.ciclista = ciclista;
    }

    public Cobranca getCobranca() {
        return cobranca;
    }

    public void setCobranca(Cobranca cobranca) {
        this.cobranca = cobranca;
    }
}
