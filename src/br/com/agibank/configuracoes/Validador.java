package br.com.agibank.configuracoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    private static Scanner scanner = new Scanner(System.in);

    public static int validarEntradaInt(String msg) {
        boolean validacao = false;
        int quantidade = 0;
        //VALIDA ENTRADA DE DADOS INT
        while (!validacao) {
            try {
                System.out.print(msg);
                quantidade = scanner.nextInt();
                scanner.nextLine();
                if(quantidade == 0) return 0;
                if (quantidade > 0) validacao = true;
                else System.out.println("Entrada inválida! Digite um número inteiro.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.nextLine();
            }
        }
        return quantidade;
    }
    public static byte validarEntradaMenu(byte max) {
        byte escolha = 0;
        boolean validacao = false;

        while (!validacao) {
            try {
                escolha = scanner.nextByte();
                scanner.nextLine();
                if (escolha <= max && escolha >= 0) {
                    validacao = true;
                } else {
                    System.out.println("Opção inválida! Escolha uma das opções acima.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Escolha uma das opções acima.");
                scanner.nextLine();
            }
        }
        return escolha;
    }
    public static String validarCpf(String msg){
        String cpf = null;
        boolean validacao = false;
        //000.000.00 0 - 0 0
        //012345678910111213
        while(!validacao) {
            System.out.print(msg);
            cpf = scanner.nextLine();
            if (cpf.equals("0")) return "0";
            if (cpf.length() == 14 && cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-') validacao = true;
            else {
                System.out.println("Insira o CPF no formato: (123.456.789-01).");
            }
        }
        return cpf;
    }
    public static String validarData(String msg){
        boolean validacao = false;
        String data = null;
        //05/01/2005
        //0123456789
        while(!validacao){
            System.out.println(msg);
            data = scanner.nextLine();
            if(data.equals("0")) return data;
            else if(data.charAt(3) != '/' || data.charAt(5) != '/'|| data.length() != 10) {
                System.out.println("Formato inválido! Siga o formato (00/00/0000).");
            }else validacao = true;
        }
        return data;
    }
}
