package com.gustavo.biblioteca.service;

import com.gustavo.biblioteca.model.Emprestimo;
import com.gustavo.biblioteca.model.Livro;
import com.gustavo.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaService {
    private List<Livro> livros;
    private Map<String, Livro> livrosPorIsnb;
    private Map<String, Usuario> usuarioPorMatricula;
    private List<Emprestimo> emprestimos;

    public BibliotecaService() {
        this.livros = new ArrayList<>();
        this.livrosPorIsnb = new HashMap<>();
        this.usuarioPorMatricula = new HashMap<>();
        this.emprestimos = new ArrayList<>();
    }


    public void cadastrarLivro(Livro livro) {};
    public void cadastrarUsuario(Usuario usuario) {};
    public void emprestarLivro(Emprestimo emprestimo) {};
    public void devolverLivro(String isnb) {};
    public Optional<Livro> buscarLivro(String isbn) {
        return Optional.empty();
    };
    public List<Livro> listarLivrosDisponiveis() {
        return new ArrayList<>();
    };



}
