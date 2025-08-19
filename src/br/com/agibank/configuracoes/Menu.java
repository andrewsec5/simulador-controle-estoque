package br.com.agibank.configuracoes;

import br.com.agibank.controle.ControleClientes;
import br.com.agibank.servicos.Servicos;

public class Menu {

    public static void exibirMenuInicial() {
        boolean validacao = false;
        byte escolha;
        //MENU INICIAL -> LOOP ENQUANTO OPÇÃO ENCERRAR NÃO FOR ESCOLHIDA
        while (!validacao) {
            System.out.println("\n=======Controle de Estoque=======");
            System.out.println("1 - Inventário\n2 - Clientes\n0 - Encerrar programa");
            System.out.print("Opção: ");
            escolha = Validador.validarEntradaMenu((byte) 2);
            if (escolha == 0) {
                System.out.println("Encerrando aplicação...");
                validacao = true;
            }
            if (escolha == 1) {
                //CHAMA O MENU DE ESTOQUE
                exibirMenuEstoque();
            }
            if (escolha == 2) {
                //CHAMA O MENU DE CLIENTES
                exibirMenuClientes();
            }
        }
    }
    public static void exibirMenuEstoque(){
        byte escolha;
        boolean menu = true;
        //MENU PARA ENTRADA, SAIDA, RESERVA E LISTAGEM DE PRODUTOS
        while (menu) {
            System.out.println("\n=======Estoque=======");
            System.out.println("1 - Cadastro de produto\n2 - Entrada de produto\n3 - Reserva de produto\n4 - Saída de produto\n5 - Lista de produtos\n0 - Sair");
            System.out.print("Opção: ");
            escolha = Validador.validarEntradaMenu((byte) 5);
            switch (escolha) {
                case 1 -> {
                    //CADASTRO DE PRODUTO
                    Servicos.cadastrarProduto();
                }
                case 2 -> {
                    //ENTRADA DE PRODUTO
                    Servicos.entradaProduto();
                }
                case 3 -> {
                    //RESERVA DE PRODUTO
                    //Servicos.reservarProduto();
                    System.out.println("Reservar produto (WIP)");
                }
                case 4 -> {
                    //SAIDA DE PRODUTO
                    Servicos.saidaProduto();
                }
                case 5 -> {
                    //LISTAGEM DE PRODUTOS
                    Servicos.listarProdutos();
                }
                case 0 -> {
                    //SAIR DO MENU
                    menu = false;
                }
            }
        }
    }
    public static void exibirMenuClientes(){
        boolean validacao = false;
        byte escolha = 0;

        while(!validacao) {
            System.out.println("\n=======CLIENTES=======");
            System.out.println("1 - Cadastro de clientes");
            System.out.println("2 - Lista de clientes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            escolha = Validador.validarEntradaMenu((byte) 2);
            switch (escolha){
                case 1 -> Servicos.cadastrarCliente();
                case 2 -> Servicos.listarClientes();
                case 0 -> validacao = true;
            }
        }
    }
}
