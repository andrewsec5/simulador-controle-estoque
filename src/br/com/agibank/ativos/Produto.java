package br.com.agibank.ativos;

public class Produto {
    protected final String nome;
    protected String dataCadastro;
    protected int quantidade;

    public Produto(String nome, String dataCadastro, int quantidade){
        this.nome = nome.toLowerCase().trim();
        this.dataCadastro = dataCadastro;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return String.format("%-15s | %11d | %-12s", nome, quantidade, dataCadastro);
    }

    /*
    public ProdutoReservado reservar(int quantidade, String cliente) {
        if(quantidade <= 0){
            throw new IllegalArgumentException("A reserva deve ser maior que 0!");
        }
        if(quantidade > this.quantidade){
            throw new IllegalArgumentException("A reserva deve ser menor ou igual a quantidade atual.");
        }
        this.quantidade -= quantidade;
        return new ProdutoReservado(this.nome, this.quantidade, cliente);
    }
     */

    public void exibirProduto(){
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Data de Cadastro: " + dataCadastro);
    }
}
