package br.com.agibank.ativos;

import java.util.List;

public class Clientes {
    private final String nome;
    private final String cpf;
    private List<ProdutoReservado> reservas;

    public Clientes(String nome, String cpf){
        this.nome = nome.toLowerCase().trim();
        this.cpf = cpf;
    }

    public String getNome(){return nome;}

    public String getCpf(){return cpf;}

    public String toString(){return String.format("%-44s | %-14s", nome, cpf);}
}
