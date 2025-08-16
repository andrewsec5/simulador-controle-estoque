package br.com.agibank.produtos;

public class ProdutoReservado {
    String nome;
    String cliente;
    public int quantidade;

    public ProdutoReservado(String nome, int quantidade, String cliente){
        this.nome = nome;
        this.quantidade = quantidade;
        this.cliente = cliente;
    }
}
