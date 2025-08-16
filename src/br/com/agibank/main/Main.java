package br.com.agibank.main;

import br.com.agibank.controle.Estoque;
import br.com.agibank.produtos.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static byte menuEstoque() {
        byte escolha = 0;
        boolean validacao = false;
        //MENU PARA ENTRADA, SAIDA, RESERVA E LISTAGEM DE PRODUTOS
        while (!validacao) {
            try {
                System.out.println("\n=======INVENTÁRIO=======");
                System.out.println("1 - Cadastro de produto\n2 - Entrada de produto\n3 - Reserva de produto\n4 - Saída de produto\n5 - Lista de produtos\n0 - Sair");
                System.out.print("Opção: ");
                escolha = scanner.nextByte();
                scanner.nextLine();
                if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0 || escolha == 4 || escolha == 5) {
                    validacao = true;
                } else System.out.println("Opção inválida! Digite 1, 2, 3, 4 ou 0.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite 1, 2, 3, 4 ou 0.");
                scanner.nextLine();
            }
        }
        return escolha;
    }

    public static int validarEntradaInt(String msg) {
        boolean validacao = false;
        int quantidade = 0;

        while (!validacao) {
            try {
                System.out.print(msg);
                quantidade = scanner.nextInt();
                scanner.nextLine();
                if (quantidade > 0) validacao = true;
                else System.out.println("Entrada inválida! Digite um número inteiro maior que 0.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro maior que 0.");
                scanner.nextLine();
            }
        }
        return quantidade;
    }

    public static Produto cadastro(String nome, String dataCadastro, int quantidade) {
        //CRIA OBJETO DE ACORDO COM DADOS DE cadastrarProduto()
        Produto produto = new Produto(nome, dataCadastro, quantidade);
        Estoque.adicionarProduto(produto);
        return produto;
    }

    public static String buscarProduto(String msg) {
        String nome;
        boolean validacao = false;
        System.out.print(msg);
        nome = scanner.nextLine();
        Produto produto = Estoque.buscarProduto(nome);
        if (produto != null) {
            validacao = true;
        } else {
            System.out.println("Produto não encontrado!");
            return "Erro";
        }
        return nome;
    }

    public static void cadastrarProduto() {
        String nome;
        String dataCadastro;
        int quantidade = 0;
        //ENTRADA DE DADOS PARA CRIAÇÃO DE OBJETO PRODUTO
        System.out.println("\n=======CADASTRO DE PRODUTO=======");
        System.out.print("Informe o nome do produto: ");
        nome = scanner.nextLine();
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        quantidade = validarEntradaInt("Insira a quantidade do produto: ");
        System.out.print("Informe a data de cadastro do produto: ");
        dataCadastro = scanner.nextLine();
        cadastro(nome, dataCadastro, quantidade);
        //EXIBIÇÃO DOS OBJETO PRODUTO CRIADO
        System.out.println("\nCADASTRO DE PRODUTO REALIZADO!");
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Data de cadastro: " + dataCadastro);
        System.out.println();
    }

    public static void entradaProduto() {
        String nome;
        int quantidade;
        //ENTRADA DE PRODUTO -> AUMENTA A QUANTIDADE DE OBJETO PRODUTO JA CRIADO!
        System.out.println("\n=======ENTRADA DE PRODUTO=======");
        nome = buscarProduto("Informe o nome do produto: ");
        if (nome == "Erro") return;
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        quantidade = validarEntradaInt("Informe a quantidade da entrada: ");
        Estoque.buscarProduto(nome).entrada(quantidade);
        System.out.println("\nENTRADA DE PRODUTO REALIZADA!");
    }

    public static void saidaProduto(){
        String nome;
        boolean validacao = false;
        int quantiaAtual;
        int quantidade = 0;
        //SAIDA DE PRODUTO -> REDUZ A QUANTIDADE DE OBJETO PRODUTO JA CRIADO!
        System.out.println("\n=======SAÍDA DE PRODUTO=======");
        nome = buscarProduto("Informe o nome do produto: ");
        if (nome == "Erro") return;
        //ATRIBUI A QUANTIDADE ATUAL DO PRODUTO A VARIAVEL quantiaAtual
        quantiaAtual = Estoque.buscarProduto(nome).getQuantidade();
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        while(!validacao) {
            quantidade = validarEntradaInt("Informe a quantidade da saída: ");
            if (quantidade > quantiaAtual) {
                System.out.println("A saída deve ser menor ou igual a quantidade atual! (" + quantiaAtual);
            }else validacao = true;
        }
        Estoque.buscarProduto(nome).saida(quantidade);
        System.out.println("\nSAÍDA DE PRODUTO REALIZADA!");
    }

    public static void listarProdutos(){
        System.out.println();
        Estoque.listarProdutos();
    }

    public static void reservarProduto() {
        String nome;
        int quantidade;
        //INCOMPLETO ******
        System.out.println("\n=======RESERVA DE PRODUTO=======");
        System.out.print("Informe o nome do produto: ");
        scanner.nextLine();
        nome = scanner.nextLine();
        System.out.print("Quantidade reservada: ");
        quantidade = scanner.nextInt();
    }

    public static void main(String[] args) {
        byte escolhaInventario;
        boolean menuEstoque = false;
        //MENU DE ESTOQUE -> LOOP ENQUANTO NÃO HOUVER INPUT == 0
        while (!menuEstoque) {
            escolhaInventario = menuEstoque();
            switch (escolhaInventario) {
                case 1 -> {
                    //CADASTRO DE PRODUTO
                    cadastrarProduto();
                }
                case 2 -> {
                    //ENTRADA DE PRODUTO
                    entradaProduto();
                }
                case 3 -> {
                    //RESERVA DE PRODUTO
                    reservarProduto();
                }
                case 4 -> {
                    //SAIDA DE PRODUTO
                    saidaProduto();
                }
                case 5 -> {
                    //LISTAGEM DE PRODUTOS
                    listarProdutos();
                }
                case 0 -> {
                    //SAIR DO MENU
                    menuEstoque = true;
                }
            }
        }


    }
}
