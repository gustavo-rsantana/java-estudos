package com.gustavo.desafio;

public class Desenvolvedor extends Funcionario implements Trabalhador{
    final String cargo = "Desenvolvedor";
    public Desenvolvedor(String nome, String cpf, int idade, double salario) {
        super(nome, cpf, idade, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println("Estou desenvolvendo um sistema em java");
    }

    @Override
    public String getCargo() {
        return cargo;
    }
}
