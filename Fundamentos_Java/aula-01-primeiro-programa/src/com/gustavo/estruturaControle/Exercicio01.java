package com.gustavo.estruturaControle;

import java.util.Scanner;

public class Exercicio01 {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int numero;

        System.out.println("Digite o numero de deseja ver sua tabuada:");
        numero = scanner.nextInt();

        for (int i = 1; i <= 10; i++){
            System.out.printf("%d * %d = %d \n", numero, i, numero * i);
        }
    }
}
