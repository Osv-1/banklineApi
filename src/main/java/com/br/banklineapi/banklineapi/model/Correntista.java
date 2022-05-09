package com.br.banklineapi.banklineapi.model;

public class Correntista {
    private Integer id;
    private String cpf;
    private String nome;
    private Correntista conta;

    public Correntista getConta() {
        return conta;
    }

    public void setConta(Correntista conta) {
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
