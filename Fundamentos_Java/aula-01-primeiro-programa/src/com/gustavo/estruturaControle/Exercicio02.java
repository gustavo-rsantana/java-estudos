package com.gustavo.estruturaControle;

import java.util.Scanner;

public class Exercicio02 {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        double altura, peso, imc;


        System.out.println("Digite sua altura:");
        altura = scanner.nextDouble();
        System.out.println("Digite seu peso:");
        peso = scanner.nextDouble();

        imc = (peso / (altura * altura));
        System.out.printf("Seu IMC e %f\n", imc);
        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc <= 24.9) {
            System.out.println("peso ideal");
        } else if (imc <= 29.9) {
        System.out.println("Levemente acima do peso");
        } else if (imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if (imc <= 39.9) {
            System.out.println("Obesidade Grau II (Severa)");
        } else {
            System.out.println("Obesidade Grau III (Morbida)");
        }
    }
}
