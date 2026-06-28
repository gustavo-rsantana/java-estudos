package com.gustavo.desafio;

public class Gerente extends Funcionario implements Trabalhador{
    final String cargo = "Gerente";

    public Gerente(String nome, String cpf, int idade, double salario) {
        super(nome, cpf, idade, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println("Estou gerenciando a equipe.");
    }

    @Override
    public String getCargo() {
        return cargo;
    }
}
