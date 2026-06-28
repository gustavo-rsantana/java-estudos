package com.gustavo.fundamentos;

import java.util.Scanner;

public class Exercicio02 {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int lado;

        System.out.println("Digite o lado do quadrado para calcular sua area:");
        lado = scanner.nextInt();

        System.out.printf("O quadrado com o lado %s tem uma area de %dm²", lado, lado * lado);
    }
}
