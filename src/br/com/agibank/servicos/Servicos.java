package br.com.agibank.servicos;

import br.com.agibank.ativos.Clientes;
import br.com.agibank.configuracoes.Validador;
import br.com.agibank.controle.ControleClientes;
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
        if(Estoque.verificarCadastro(nome)) return;
        //TRATA A ENTRADA DE DADOS -> x > 0 / x == número inteiro
        quantidade = Validador.validarEntradaInt("Insira a quantidade do produto (Digite 0 para cancelar): ");
        if(quantidade == 0) return;
        dataCadastro = Validador.validarData("Informe a data de cadastro do produto (Digite 0 para cancelar): ");
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
        Estoque.listarProdutos();
    }


    public static void reservarProduto() {
        String nomeProduto;
        String nomeCliente;
        int quantidade;
        boolean validacao = false;

        System.out.println("\n=======RESERVA DE PRODUTO=======");
        System.out.print("Informe o nome do produto (Digite 0 para cancelar): ");
        scanner.nextLine();
        nomeProduto = scanner.nextLine();
        if(nomeProduto.equals("0")) return;
        if(!Estoque.verificarCadastro(nomeProduto)) return;
        if(Estoque.buscarProduto(nomeProduto).getQuantidade() == 0){
            System.out.println("Esse produto está em falta!");
            return;
        }
        Clientes cliente = ControleClientes.procurarCliente("Informe o nome do cliente da reserva (Digite 0 para cancelar): ");
        if(cliente == null) return;
        while(!validacao) {
            quantidade = Validador.validarEntradaInt("Insira a quantidade da reserva (Digite 0 para cancelar): ");
            if (quantidade == 0) return;
            if (Estoque.buscarProduto(nomeProduto).getQuantidade() < quantidade) {
                System.out.println("A quantidade informada deve ser menor ou igual ao estoque do produto (" + Estoque.buscarProduto(nomeProduto).getQuantidade() + ").");
            }else validacao = true;
        }
        //ADICIONAR DATA DE RESERVA

    }


    public static void cadastrarCliente() {
        String nome;
        String cpf;

        System.out.println("\n=======CADASTRO DE CLIENTE=======");
        System.out.print("Informe o nome do cliente (Digite 0 para cancelar): ");
        nome = scanner.nextLine();
        if (nome.equals("0")) return;
        if(ControleClientes.verificarCliente(nome)) return;
        cpf = Validador.validarCpf("Insira o cpf do cliente (Digite 0 para cancelar): ");
        if(cpf.equals("0")) return;
        Clientes cliente = new Clientes(nome, cpf);
        ControleClientes.adicionarCliente(cliente);
        System.out.println("\nCADASTRO REALIZADO!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
    }

    public static void listarClientes(){
        System.out.println();
        ControleClientes.listarClientes();

    }

    public static void pesquisarCliente(){
        System.out.println("\n=======PESQUISAR CLIENTE=======");
        Clientes cliente = ControleClientes.procurarCliente("Insira o nome do cliente (Digite 0 para cancelar):");
        if(cliente == null) return;
        System.out.println();
        System.out.println("CLIENTE ENCONTRADO!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Produtos reservados: ");
    }
}
