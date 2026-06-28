package com.gustavo.desafio;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String nome;
        char sexo;
        int anoNascimento, estadoCivil;
        double peso, altura;

        System.out.println("Sistema de Cadastro e analise de pessoas");
        System.out.print("Qual seu nome: ");
        nome = scanner.next();
        System.out.print("Qual o ano do seu nascimento: ");
        anoNascimento = scanner.nextInt();
        System.out.print("Qual o seu peso: ");
        peso = scanner.nextFloat();
        System.out.print("Qual a sua altura: ");
        altura = scanner.nextFloat();
        System.out.print("Sexo M/F: ");
        sexo = scanner.next().toLowerCase().charAt(0);
        String tipoSexo = sexo == 'm' ? "Masculino" : "Feminino";
        System.out.print("""
                Estado civil
                1 - Solteiro(a)
                2 - Casado(a)
                3 - Divorciado(a)
                4 - Viúvo(a)
                """);
        estadoCivil = scanner.nextInt();
        String situacaoCivil;

        if (estadoCivil == 1) {
            situacaoCivil = "Solteiro(a)";
        } else if (estadoCivil == 2) {
            situacaoCivil = "Casado(a)";
        } else if (estadoCivil == 3) {
            situacaoCivil = "3 - Divorciado(a)";
        } else if (estadoCivil == 4) {
            situacaoCivil = "Viúvo(a)";
        } else {
            situacaoCivil = "opção Invalida";
        }

        var idade = LocalDate.now().getYear() - anoNascimento;
        var maiorIdade = idade >= 18 ? "Maior de idade." : "Menor de idade";
        var idadeParImpar = idade % 2 == 0 ? "Par" : "Impar";
        String idadeSituacao;
        if (idade <= 12) {
            idadeSituacao = "Criança";
        } else if (idade < 18) {
            idadeSituacao = "Adolecente";
        } else if (idade < 60) {
            idadeSituacao = "Adulto";
        } else {
            idadeSituacao = "Idoso";
        }




        var imc = peso / (altura * altura);
        String imcResult;
        if (imc < 18.5) {
            imcResult = "Abaixo do peso.";
        } else if (imc < 25) {
            imcResult = "Peso normal.";
        } else if (imc < 30) {
            imcResult = "Sobrepeso.";
        } else if (imc < 35) {
            imcResult = "Obesidade Gra I";
        } else if (imc < 40) {
            imcResult = "Obesidade Gra II";
        } else {
            imcResult = "Obesidade Gra III";
        }


        System.out.printf("""
                ======================================
                           DADOS DO USUARIO
                ======================================
                Nome: %s
                
                Idade: %d anos
                
                Sexo: %s
                
                Estado Civil: %s
                
                Altura: %.2f
                
                peso: %.2f
                
                IMC: %.2f
                
                Clasiificação: %s
                
                %s
                
                %s
                
                A idade é %s
                
                ======================================
                """, nome, idade, tipoSexo, situacaoCivil, altura, peso, imc, imcResult, maiorIdade, idadeSituacao, idadeParImpar);



    }
}
