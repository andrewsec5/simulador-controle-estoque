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
                if (quantidade > 0) validacao = true;
                else System.out.println("Entrada inválida! Digite um número inteiro maior que 0.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro maior que 0.");
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

    public static void validarCpf(String cpf){

    }
}
