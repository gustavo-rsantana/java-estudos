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
    public void emprestarLivro(Emprestimo emprestimo) {
        if (!buscarUsuario(emprestimo.getUsuario().getMatricula()).isPresent()) {
            System.out.println("Usuário não encontrado");
            return;
        }

        if(!buscarLivro(emprestimo.getLivro().getIsbn()).isPresent()) {
            System.out.println("Livro não encontrado");
            return;
        }

        var lista = listarLivrosDisponiveis();

        Optional<Livro> livroSelecionado = lista.stream().
                filter(livro -> emprestimo.getLivro().getIsbn().equals(livro.getIsbn()))
                .findFirst();


        if (livroSelecionado.isPresent()) {
            Livro livro = livroSelecionado.get();
            livro.setStatus(StatusLivro.EMPRESTADO);
        } else {
            System.out.println("Livro não disponivel.");
            return;
        }

        novoEmprestimo(emprestimo);
        emprestimos.add(emprestimo);


    }

    public void novoEmprestimo(Emprestimo emprestimo ) {
        Usuario usuario = emprestimo.getUsuario();
        Livro livro = emprestimo.getLivro();
        LocalDate date = LocalDate.now();
        LocalDate previsaoDevolucao = LocalDate.now().plusDays(5);
        String observacao = emprestimo.getObservacao();
        Emprestimo novo = new Emprestimo(usuario, livro, date, previsaoDevolucao, observacao);
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
