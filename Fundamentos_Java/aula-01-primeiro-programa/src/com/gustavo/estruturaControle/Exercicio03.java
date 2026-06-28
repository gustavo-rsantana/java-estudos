package com.gustavo.estruturaControle;

import java.util.Scanner;

public class Exercicio03 {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int menor, maior;
        String opcao;

        while(true) {
            System.out.println("Digite o menor Numero:");
            menor = scanner.nextInt();
            System.out.println("Digite o maior Numero");
            maior = scanner.nextInt();
            System.out.println("Quais numero quer ver Par ou Impar");
            opcao = scanner.next().toLowerCase();
            switch (opcao){
                case "par": {
                    for (int i = menor; i <= maior; i++){
                        if (i % 2 == 0) {
                            System.out.println(i);
                        }
                    }
                    System.exit(0);
                    break;
                }
                case "impar": {
                    for (int i = menor; i <= maior; i++){
                        if (i % 2 != 0) {
                            System.out.println(i);
                        }
                    }
                    System.exit(0);
                    break;
                }
                case "exit": System.exit(0);
                default:
                    System.out.println("Opção invalida!");
            }
        }

    }
}
