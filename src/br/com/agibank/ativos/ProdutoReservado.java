package br.com.agibank.ativos;

import java.lang.ref.Cleaner;

public class ProdutoReservado extends Produto {
    private Clientes cliente;
    private String dataRetirada;

    public ProdutoReservado(String nome, int quantidade, String dataCadastro, Clientes cliente){
        //MONTAR DPS
        super(nome, dataCadastro, quantidade);
        this.cliente = cliente;
    }

}
