package br.com.agibank.main;
import java.util.Scanner;

public class Main {

    public static byte menuEstoque(Scanner scanner){
        byte escolha = 0;
        boolean validacao = false;

        while(!validacao) {
            try {
                System.out.println("=======INVENTÁRIO=======");
                System.out.println("1 - Entrada de produto\n2 - Reserva de produto\n3 - Saída de produto");
                System.out.print("Opção: ");
                escolha = scanner.nextByte();
            }catch(NumberFormatException e){

            }
        }
        return escolha;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte escolhaInventario;

        escolhaInventario = menuEstoque(scanner);
        switch (escolhaInventario){
            case 1 -> System.out.println("menu 1");
            case 2 -> System.out.println("menu 2");
            case 3 -> System.out.println("menu 3") ;
            default -> System.out.println("Opção Inválida!");
        }

    }
}
