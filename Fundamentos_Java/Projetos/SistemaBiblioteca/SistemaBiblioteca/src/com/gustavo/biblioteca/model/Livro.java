package com.gustavo.biblioteca.model;

public class Livro {
    private String isbn;
    private String titulo;
    private String genero;
    private String autor;
    private int anoPublicacao;
    private  String editora;
    private int edicao;
    private String resumo;
    private StatusLivro status;


    public Livro(String isbn, String titulo, String genero, String autor, int anoPublicacao, String editora, int edicao, String resumo, StatusLivro status) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.edicao = edicao;
        this.resumo = resumo;
        this.status = status;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public int getEdicao() {
        return edicao;
    }


    public String getResumo() {
        return resumo;
    }

    public StatusLivro getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", editora='" + editora + '\'' +
                ", edicao=" + edicao +
                ", resumo='" + resumo + '\'' +
                ", status=" + status +
                '}';
    }
}
