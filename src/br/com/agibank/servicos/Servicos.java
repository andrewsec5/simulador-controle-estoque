package br.com.agibank.servicos;

import br.com.agibank.configuracoes.Validador;
import br.com.agibank.controle.Estoque;
import br.com.agibank.controle.MovimentacaoEstoque;

import java.util.Scanner;

public class Servicos {

    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarProduto() {
        String nome;
        String dataCadastro;
        int quantidade;
        //ENTRADA DE DADOS PARA CRIAÇÃO DE OBJETO PRODUTO
        System.out.println("\n=======CADASTRO DE PRODUTO=======");
        System.out.print("Informe o nome do produto (Digite 0 para cancelar): ");
        nome = scanner.nextLine();
        if(nome.equals("0")) return;
        if(Estoque.verificarCadastro(nome) == true) return;
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        quantidade = Validador.validarEntradaInt("Insira a quantidade do produto: ");
        System.out.print("Informe a data de cadastro do produto (Digite 0 para cancelar): ");
        dataCadastro = scanner.nextLine();
        if(dataCadastro.equals("0")) return;
        Estoque.cadastro(nome, dataCadastro, quantidade);
        //EXIBIÇÃO DOS OBJETO PRODUTO CRIADO
        System.out.println("\nCADASTRO DE PRODUTO REALIZADO!");
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Data de cadastro: " + dataCadastro);
        System.out.println();
    }

    public static void entradaProduto() {
        String nome = null;
        boolean validacao = false;
        int quantidade;
        while(!validacao) {
            //ENTRADA DE PRODUTO -> AUMENTA A QUANTIDADE DE OBJETO PRODUTO JA CRIADO!
            System.out.println("\n=======ENTRADA DE PRODUTO=======");
            nome = Estoque.verificarProduto("Informe o nome do produto (Digite 0 para cancelar): ");
            if (nome.equals("0")) return;
            if (!nome.equals("Erro")) validacao = true;
        }
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        quantidade = Validador.validarEntradaInt("Informe a quantidade da entrada (Digite 0 para cancelar): ");
        if(quantidade == 0) return;
        MovimentacaoEstoque.entrada(Estoque.buscarProduto(nome), quantidade);
        System.out.println("\nENTRADA DE PRODUTO REALIZADA!");
    }

    public static void saidaProduto() {
        String nome = null;
        boolean validacao = false;
        boolean validacaoInicial = false;
        int quantiaAtual;
        int quantidade = 0;
        //SAIDA DE PRODUTO -> REDUZ A QUANTIDADE DE OBJETO PRODUTO JA CRIADO!
        while(!validacaoInicial) {
            System.out.println("\n=======SAÍDA DE PRODUTO=======");
            nome = Estoque.verificarProduto("Informe o nome do produto (Digite 0 para cancelar): ");
            if (nome.equals("0")) return;
            if (!nome.equals("Erro")) validacaoInicial = true;
        }
        //ATRIBUI A QUANTIDADE ATUAL DO PRODUTO A VARIAVEL quantiaAtual
        quantiaAtual = Estoque.buscarProduto(nome).getQuantidade();
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        while (!validacao) {
            quantidade = Validador.validarEntradaInt("Informe a quantidade da saída (Digite 0 para cancelar): ");
            if(quantidade == 0) return;
            if (quantidade > quantiaAtual) {
                System.out.println("A saída deve ser menor ou igual a quantidade atual! (" + quantiaAtual + ")");
            } else validacao = true;
        }
        MovimentacaoEstoque.saida(Estoque.buscarProduto(nome), quantidade);
        System.out.println("\nSAÍDA DE PRODUTO REALIZADA!");
    }

    public static void listarProdutos() {
        System.out.println();
        Estoque.listarProdutos();
    }

    /*
    public static void reservarProduto() {
        //TERMINAR DE FAZER
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
   */
}
