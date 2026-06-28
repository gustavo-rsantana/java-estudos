package com.gustavo.desafio;

public class Estagiario extends Funcionario implements Trabalhador{
    final String cargo = "Estagiario";

    public Estagiario(String nome, String cpf, int idade, double salario) {
        super(nome, cpf, idade, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println("Estou aprendendo e auxiliando a equipe.");
    }

    @Override
    public String getCargo() {
        return cargo;
    }
}
