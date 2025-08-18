package br.com.agibank.ativos;

import java.util.List;

public class Clientes {
    private final String nome;
    private final String cpf;
    private List<ProdutoReservado> reservas;

    public Clientes(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

}
