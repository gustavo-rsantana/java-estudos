package com.gustavo.biblioteca.service;

import com.gustavo.biblioteca.enums.StatusLivro;
import com.gustavo.biblioteca.model.Emprestimo;
import com.gustavo.biblioteca.model.Livro;
import com.gustavo.biblioteca.model.Usuario;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BibliotecaService {
    private List<Livro> livros;
    private Map<String, Livro> livrosPorIsbn;
    private Map<Integer, Usuario> usuariosPorMatricula;
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
    public void cadastrarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getMatricula()).isPresent()) {
            System.out.println("Usuário já cadastrado.");
            return;
        }
        usuariosPorMatricula.put(usuario.getMatricula(), usuario);
    }
    public void emprestarLivro(String isbn, int matricula, String observacao) {
        Optional<Usuario> usuarioEncontrado = buscarUsuario(matricula);
        Optional<Livro> livroEncontrado = buscarLivro(isbn);


        if (usuarioEncontrado.isEmpty()) {
            System.out.println("Usuário não encontrado");
            return;
        }

        if(livroEncontrado.isEmpty()) {
            System.out.println("Livro não encontrado");
            return;
        }

        Livro livro = livroEncontrado.get();

        if (!StatusLivro.DISPONIVEL.equals(livro.getStatus())) {
            System.out.println("Livro não disponível.");
            return;
        }

        Usuario usuario = usuarioEncontrado.get();

        Emprestimo emprestimo = new Emprestimo(
                usuario,
                livro,
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                observacao
        );

        livro.setStatus(StatusLivro.EMPRESTADO);
        emprestimos.add(emprestimo);


    }




    public void devolverLivro(String isbn) {}

    public Optional<Livro> buscarLivro(String isbn) {
        Livro livroSelecionado = livrosPorIsbn.get(isbn);

        return Optional.ofNullable(livroSelecionado);
    }

    public Optional<Usuario> buscarUsuario(int matricula) {
        Usuario usuarioSelecionado = usuariosPorMatricula.get(matricula);

        return Optional.ofNullable(usuarioSelecionado);
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = livrosPorIsbn.values().stream()
                .filter( livro -> StatusLivro.DISPONIVEL.equals(livro.getStatus()))
                .collect(Collectors.toList());

        return livrosDisponiveis;
    }



}
