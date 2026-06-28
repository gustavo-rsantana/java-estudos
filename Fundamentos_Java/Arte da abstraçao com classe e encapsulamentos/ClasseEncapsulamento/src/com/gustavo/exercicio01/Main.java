package com.gustavo.exercicio01;

import java.util.Scanner;

public class Main {
    static void main() {
        var scanner = new Scanner(System.in);
        int options;
        ContaBancaria conta = new ContaBancaria(criarConta());
        do {
            System.out.print("""
                    =================
                    Escolha uma opção
                    =================
                    1 - Saldo.
                    2 - Cheque Especial.
                    3 - Deposito.
                    4 - Sacar.
                    5 - Pagar Boleto.
                    0 - Sair do Sistema
                    """);
            options = scanner.nextInt();

            switch (options){
                case 1 -> System.out.printf("Seu saldo e de R$%.2f \n", conta.getSaldo());
                case 2 -> conta.consultarCheuqeEspecial();
                case 3 -> depositar(scanner, conta);
                case 4 -> sacar(scanner, conta);
                case 5 -> pagar(scanner, conta);
                case 0 -> System.exit(0);
                default -> System.out.println("Opção invaloda");
            }
        } while (true);


    }


    private static  void pagar(Scanner scanner, ContaBancaria conta) {
        System.out.println("Qual o valor do boleto");
        var valor = scanner.nextDouble();
        conta.pagar(valor);

    }

    private static void sacar(Scanner scanner, ContaBancaria conta) {
        System.out.print("Quanto gostaria de sacar: ");
        var valor = scanner.nextDouble();
        conta.sacar(valor);
    }

    private static void depositar(Scanner scanner, ContaBancaria conta) {
        System.out.print("Qual o valor do deposito: ");
        var valor = scanner.nextDouble();
        conta.depositar(valor);
    }


    private static double criarConta() {
        var scanner = new Scanner(System.in);
        System.out.println("Primeiro devemos criar uma conta: ");
        System.out.print("Digite o valor que ira depositar na abertura da conta: ");
        double valor = scanner.nextDouble();
        System.out.printf("""
                    Conta criada
                    Valor depositado %.2f
                    
                    """, valor);

        return valor;
    }


}
