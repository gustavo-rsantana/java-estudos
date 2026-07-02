package com.gustavo.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private LocalDate dataNascimento;
    private int matricula;
    private List<Livro> livrosJaLidos = new ArrayList<>();

    public Usuario(String nome, String cpf, String endereco, LocalDate dataNascimento, int matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public List<Livro> getLivrosJaLidos() {
        return livrosJaLidos;
    }

    public void adicionarLivros(Livro livro) {
        livrosJaLidos.add(livro);
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
