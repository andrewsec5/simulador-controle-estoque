package br.com.agibank.controle;

import br.com.agibank.produtos.Produto;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
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
}
