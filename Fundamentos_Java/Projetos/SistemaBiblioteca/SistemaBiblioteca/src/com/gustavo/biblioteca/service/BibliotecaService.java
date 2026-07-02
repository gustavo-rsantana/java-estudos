package com.gustavo.biblioteca.service;

import com.gustavo.biblioteca.model.Emprestimo;
import com.gustavo.biblioteca.model.Livro;
import com.gustavo.biblioteca.model.Usuario;

import java.util.*;

public class BibliotecaService {
    private List<Livro> livros;
    private Map<String, Livro> livroPorIsnb;
    private Map<String, Usuario> usuarioPorMatricula;
    private List<Emprestimo> emprestimos;

    public BibliotecaService() {
        this.livros = new ArrayList<>();
        this.livroPorIsnb = new HashMap<>();
        this.usuarioPorMatricula = new HashMap<>();
        this.emprestimos = new ArrayList<>();
    }


    public void cadastrarLivro() {};
    public void cadastrarUsuario() {};
    public void emprestarLivro() {};
    public void devolverLivro() {};
    public Optional<Livro> buscarLivro() {};
    public List<Livro> listarLivrosDisponiveis() {};
    public void adicionarMulta() {};



}
