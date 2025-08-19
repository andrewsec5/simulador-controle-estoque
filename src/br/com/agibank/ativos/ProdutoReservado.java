package br.com.agibank.ativos;

public class ProdutoReservado extends Produto {
    String cliente;
    String dataRetirada;

    public ProdutoReservado(String nome, int quantidade, String dataCadastro, String dataRetirada, String cliente){
        super(nome, dataCadastro, quantidade);
        this.cliente = cliente;
        this.dataRetirada = dataRetirada;
    }

}
