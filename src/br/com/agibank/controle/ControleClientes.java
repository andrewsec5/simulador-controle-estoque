package br.com.agibank.controle;

import br.com.agibank.ativos.Clientes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleClientes {

    public static Scanner scanner = new Scanner(System.in);

    private static Map<String, Clientes> mapaClientes = new HashMap<>();

    public static void adicionarCliente(Clientes cliente){
        mapaClientes.put(cliente.getNome().toLowerCase().trim(), cliente);
    }

    public void cadastrarCliente(String nome, String cpf){
        Clientes cliente = new Clientes(nome, cpf);
    }

    public static Clientes buscarCliente(String nome){return mapaClientes.get(nome.toLowerCase().trim());}

    public static String procurarCliente(String msg){
        String nome;

        System.out.println(msg);
        nome = scanner.nextLine();
        if(nome.equals("0")) ;
        Clientes clientes = buscarCliente(nome);
        if(clientes == null){
            System.out.println("Cliente não encontrado!");
            return "Erro";
        }
        return nome;
    }

    public static boolean verificarCliente(String nome){
        if(buscarCliente(nome) != null){
            System.out.println("Cliente já cadastrado!");
            return true;
        }
        return false;
    }

    public static void listarClientes(){
        if(mapaClientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        System.out.printf("%-44s | %-14s", "Cliente:", "CPF:");
        System.out.print("\n--------------------------------------------------------------\n");
        for(Clientes clientes : mapaClientes.values()){
            System.out.println(clientes);
        }
    }

}
