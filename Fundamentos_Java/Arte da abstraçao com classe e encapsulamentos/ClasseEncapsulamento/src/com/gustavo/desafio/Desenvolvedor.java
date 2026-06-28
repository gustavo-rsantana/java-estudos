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
    public void mostraDados() {
        super.mostraDados();
        System.out.printf("""
                =========================
                Funcionário
                
                Nome: %s
                
                Idade: %d
                
                CPF: %s
                
                Salário: %.2f
                
                Cargo: %s
                =========================
                """, this.nome, this.idade, this.cpf, this.salario, this.cargo);
    }
}
