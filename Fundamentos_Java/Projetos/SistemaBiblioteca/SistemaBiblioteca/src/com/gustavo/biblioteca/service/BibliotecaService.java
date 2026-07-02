package com.gustavo.biblioteca.service;

import com.gustavo.biblioteca.model.Emprestimo;
import com.gustavo.biblioteca.model.Livro;
import com.gustavo.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaService {
    private List<Livro> livros;
    private Map<String, Livro> livrosPorIsbn;
    private Map<String, Usuario> usuariosPorMatricula;
    private List<Emprestimo> emprestimos;

    public BibliotecaService() {
        this.livros = new ArrayList<>();
        this.livrosPorIsbn = new HashMap<>();
        this.usuariosPorMatricula = new HashMap<>();
        this.emprestimos = new ArrayList<>();
    }


    public void cadastrarLivro(Livro livro) {
        if (buscarLivro(livro.getIsbn()).isPresent()) {
            System.out.println("Livro ja Cadastrado.");
            return;
        }
        livros.add(livro);
        livrosPorIsbn.put(livro.getIsbn(), livro);
    }
    public void cadastrarUsuario(Usuario usuario) {}
    public void emprestarLivro(Emprestimo emprestimo) {}
    public void devolverLivro(String isbn) {}

    public Optional<Livro> buscarLivro(String isbn) {
        Livro livroSelecionado = livrosPorIsbn.get(isbn);

        return Optional.ofNullable(livroSelecionado);
    }
    public List<Livro> listarLivrosDisponiveis() {
        return new ArrayList<>();
    }



}
