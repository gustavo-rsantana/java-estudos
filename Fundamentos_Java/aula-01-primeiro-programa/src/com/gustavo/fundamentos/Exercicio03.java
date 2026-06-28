package com.gustavo.fundamentos;

import java.util.Scanner;

public class Exercicio03 {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int base;
        int altura;


        System.out.println("Digite a base:");
        base = scanner.nextInt();
        System.out.println("Digite a altura:");
        altura = scanner.nextInt();
        int area = base * altura;
        System.out.printf("A base de: %sm e a altura de: %dm formaam uma area de %dm²", base, altura, area);

    }
}
