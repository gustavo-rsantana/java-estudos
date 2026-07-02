package com.gustavo.biblioteca.model;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private int dataNascimento;
    private int matricula;
    private ArrayList<Livro> livrosJaLidos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }



    public int getMatricula() {
        return matricula;
    }


    public ArrayList<Livro> getLivrosJaLidos() {
        return livrosJaLidos;
    }

    public void setLivrosJaLidos(ArrayList<Livro> livrosJaLidos) {
        this.livrosJaLidos = livrosJaLidos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", matricula=" + matricula +
                ", livrosJaLidos=" + livrosJaLidos +
                '}';
    }
}
