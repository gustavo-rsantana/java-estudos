package com.gustavo.desafio;

public abstract class Funcionario extends Pessoa{
    double salario;

    public double getSalario() {
        return salario;
    }

    public abstract String getCargo();

    public Funcionario(String nome, String cpf, int idade, double salario) {
        super(nome, cpf, idade);
        this.salario = salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void receberSalario() {
        System.out.println("recebendo meu salario de R$ " + this.salario );
    }

    public void aumentarSalario(double percentual) {
        this.salario += (this.salario * percentual) / 100;
    }


    public void mostraDados() {
        System.out.printf("""
                =========================
                Funcionário
                
                Nome: %s
                
                Idade: %d
                
                CPF: %s
                
                Salário: %.2f
                
                Cargo: %s
                =========================
                """, this.nome, this.idade, this.cpf, this.salario, getCargo());
    }
}
