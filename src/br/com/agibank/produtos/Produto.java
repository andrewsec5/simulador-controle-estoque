package br.com.agibank.produtos;

public class Produto {
    private final String nome;
    private String dataCadastro;
    private int quantidade;

    public Produto(String nome, String dataCadastro, int quantidade){
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public String toString(){
        return String.format("%-15s | %11d | %-12s", nome, quantidade, dataCadastro);
    }

    public void entrada(int quantidade) {
        if(quantidade <= 0){
            throw new IllegalArgumentException("A entrada deve ser maior que 0!");
        }
        this.quantidade += quantidade;
    }

    public void saida(int quantidade) {
        if(quantidade <= 0){
            throw new IllegalArgumentException("A saída deve ser maior que 0!");
        }
        if(quantidade > this.quantidade){
            throw new IllegalArgumentException("A saída deve ser menor ou igual a quantidade atual.");
        }
        this.quantidade -= quantidade;
    }

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

    public void exibirProduto(){
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Data de Cadastro: " + dataCadastro);
    }
}
