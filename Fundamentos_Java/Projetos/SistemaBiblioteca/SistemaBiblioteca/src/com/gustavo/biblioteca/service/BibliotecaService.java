package com.gustavo.biblioteca.service;

import com.gustavo.biblioteca.enums.StatusLivro;
import com.gustavo.biblioteca.exception.LivroIndisponivelException;
import com.gustavo.biblioteca.exception.LivroNaoEncontradoException;
import com.gustavo.biblioteca.exception.UsuarioNaoEncontradoException;
import com.gustavo.biblioteca.model.Emprestimo;
import com.gustavo.biblioteca.model.Livro;
import com.gustavo.biblioteca.model.Usuario;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
        Livro livro = buscarLivroObrigatorio(isbn);
        Usuario usuario = buscarUsuarioObrigatorio(matricula);

        if (!StatusLivro.DISPONIVEL.equals(livro.getStatus())) {
            new LivroIndisponivelException("Livro indisponivel no momento!");
        }

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

    public void devolverLivro(String isbn) {
        Livro livro = buscarLivroObrigatorio(isbn);

        Optional<Emprestimo> emprestimoEncontra = buscarEmprestimo(isbn);

        if (emprestimoEncontra.isEmpty()) {
            System.out.println("Livro não estava emprestado");
            return;
        }


        Emprestimo emprestimo = emprestimoEncontra.get();

        emprestimo.setDevolucao(LocalDate.now());

       long dias = ChronoUnit.DAYS.between(
            emprestimo.getPrevisaoDevolucao(),
                LocalDate.now()
        );

        if (dias > 0) {
            BigDecimal multa = BigDecimal.valueOf(dias)
                            .multiply(BigDecimal.valueOf(2));
            System.out.println("Foi aplicado uma multa no valor de R$" + multa);
            emprestimo.aplicarMulta(multa);
        }

      livro.setStatus(StatusLivro.DISPONIVEL);

    Usuario usuario = emprestimo.getUsuario();

        usuario.adicionarLivroLido(livro);

    }


    public Optional<Livro> buscarLivro(String isbn) {
        Livro livroSelecionado = livrosPorIsbn.get(isbn);

        return Optional.ofNullable(livroSelecionado);
    }

    private Livro buscarLivroObrigatorio(String isbn) {
        return buscarLivro(isbn)
                .orElseThrow(() -> new LivroNaoEncontradoException(
                        "Livro não encontrado para o ISBN: " + isbn
                ));
    }

    public Optional<Usuario> buscarUsuario(int matricula) {
        Usuario usuarioSelecionado = usuariosPorMatricula.get(matricula);

        return Optional.ofNullable(usuarioSelecionado);
    }

    public Usuario buscarUsuarioObrigatorio(int matricula) {
        return buscarUsuario(matricula)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com a matrícula: " + matricula
                ));
    }

    public Optional<Emprestimo> buscarEmprestimo(String isbn) {
        return emprestimos.stream()
                .filter(emprestimo -> emprestimo.getLivro().getIsbn().equals(isbn))
                .filter(emprestimo -> emprestimo.getDevolucao() == null)
                .findFirst();
    }


    public List<Livro> listarLivrosDisponiveis() {
        return livros.stream()
                .filter(livro -> livro.getStatus().equals(StatusLivro.DISPONIVEL))
                .toList();
    }



    public List<Livro> listarLivrosEmprestado() {
        return livros.stream()
                .filter(livro -> livro.getStatus().equals(StatusLivro.EMPRESTADO))
                .toList();
    }



}
