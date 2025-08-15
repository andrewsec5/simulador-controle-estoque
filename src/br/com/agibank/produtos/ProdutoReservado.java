package br.com.agibank.produtos;

public class ProdutoReservado {
    public String nome;
    public int quantidade;
    public String cliente;

    public ProdutoReservado(String nome, int quantidade, String cliente){
        this.nome = nome;
        this.quantidade = quantidade;
        this.cliente = cliente;
    }
}
