package br.com.agibank.controle;

import br.com.agibank.ativos.Produto;

public class MovimentacaoEstoque {

    public static void entrada(Produto nome, int quantidade) {
        nome.setQuantidade(nome.getQuantidade() + quantidade);
    }
    public static void saida(Produto nome, int quantidade){
        nome.setQuantidade(nome.getQuantidade() - quantidade);
    }
}
