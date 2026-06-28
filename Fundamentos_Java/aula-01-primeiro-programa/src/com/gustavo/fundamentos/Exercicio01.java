package com.gustavo.fundamentos;

import java.time.LocalDate;
import java.util.Scanner;

public class Exercicio01 {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);

        String nome;
        int ano;
        int anoAtual = LocalDate.now().getYear();

        System.out.println("Digite seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Digite o ano de nascimento: ");
        ano = scanner.nextInt();

        int idade = anoAtual - ano;

        System.out.printf("Olá %s você tem %d anos", nome, idade);



    }
}
