package br.com.agibank.controle;

import br.com.agibank.ativos.Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {

    private static Scanner scanner = new Scanner(System.in);

    private static Map<String, Produto> estoque = new HashMap<>();

    public static void adicionarProduto(Produto produto){
        estoque.put(produto.getNome().toLowerCase().trim(), produto);
    }
    public static Produto buscarProduto(String nome){
        return estoque.get(nome.toLowerCase().trim());
    }

    public static void listarProdutos(){
        if(estoque.isEmpty()){
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }
        System.out.printf("%-15s | %5s | %-12s", "Produto:", "Quantidade:", "Data de Cadastro:");
        System.out.println("\n-------------------------------------------------");
        for(Produto produto : estoque.values()){
            System.out.println(produto);
        }
    }
    public static String verificarProduto(String msg) {
        String nome;
        System.out.print(msg);
        nome = scanner.nextLine();
        if(nome.equals("0")) return "0";
        Produto produto = Estoque.buscarProduto(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return "Erro";
        }
        return nome;
    }
    public static boolean verificarCadastro(String nome){
        if(buscarProduto(nome) != null){
            System.out.println("Produto já cadastrado!");
            return true;
        }
        return false;
    }

    public static Produto cadastro(String nome, String dataCadastro, int quantidade) {
        //CRIA OBJETO DE ACORDO COM DADOS DE cadastrarProduto()
        Produto produto = new Produto(nome, dataCadastro, quantidade);
        Estoque.adicionarProduto(produto);
        return produto;
    }
}
