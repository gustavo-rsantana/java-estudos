package com.gustavo.desafio;

public class Main {
    public static void main(String[] args) {
        Desenvolvedor desenvolvedor = new Desenvolvedor("Gustavo", "012.345.678-90", 39,5000);
        Gerente gerente = new Gerente("Adriana", "000000000000", 42, 4500);
        Estagiario estagiario = new Estagiario("Isadora","00000000", 13, 100);


        desenvolvedor.apresentar();
        gerente.apresentar();
        estagiario.apresentar();

        desenvolvedor.trabalhar();
        gerente.trabalhar();
        estagiario.trabalhar();

        desenvolvedor.receberSalario();
        gerente.receberSalario();
        estagiario.receberSalario();

        desenvolvedor.aumentarSalario(10);
        gerente.aumentarSalario(15);
        estagiario.aumentarSalario(250);

        System.out.println(desenvolvedor.getSalario());
        System.out.println(gerente.getSalario());
        System.out.println(estagiario.getSalario());

        desenvolvedor.mostraDados();
        gerente.mostraDados();
        estagiario.mostraDados();
    }
}
