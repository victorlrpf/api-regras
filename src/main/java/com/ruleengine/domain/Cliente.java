package com.ruleengine.domain;

import java.math.BigDecimal;

public class Cliente {
    private Long id;
    private String nome;
    private int idade;
    private int totalCompras;
    private BigDecimal valorTotalGasto;
    private StatusCliente status;
    private CategoriaCliente categoria;
    private RiscoCliente risco;
    private BigDecimal cashback;

    public Cliente(Long id, String nome, int idade, int totalCompras, BigDecimal valorTotalGasto, StatusCliente status, CategoriaCliente categoria, RiscoCliente risco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.totalCompras = totalCompras;
        this.valorTotalGasto = valorTotalGasto;
        this.status = status;
        this.categoria = categoria;
        this.risco = risco;
        this.cashback = BigDecimal.ZERO;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public int getTotalCompras() { return totalCompras; }
    public void setTotalCompras(int totalCompras) { this.totalCompras = totalCompras; }

    public BigDecimal getValorTotalGasto() { return valorTotalGasto; }
    public void setValorTotalGasto(BigDecimal valorTotalGasto) { this.valorTotalGasto = valorTotalGasto; }

    public StatusCliente getStatus() { return status; }
    public void setStatus(StatusCliente status) { this.status = status; }

    public CategoriaCliente getCategoria() { return categoria; }
    public void setCategoria(CategoriaCliente categoria) { this.categoria = categoria; }

    public RiscoCliente getRisco() { return risco; }
    public void setRisco(RiscoCliente risco) { this.risco = risco; }

    public BigDecimal getCashback() { return cashback; }
    public void setCashback(BigDecimal cashback) { this.cashback = cashback; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", categoria=" + categoria +
                ", risco=" + risco +
                ", valorTotalGasto=" + valorTotalGasto +
                ", cashback=" + cashback +
                '}';
    }
}
