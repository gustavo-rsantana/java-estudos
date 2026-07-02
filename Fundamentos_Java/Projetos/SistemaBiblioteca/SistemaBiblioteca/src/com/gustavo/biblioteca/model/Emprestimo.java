package com.gustavo.biblioteca.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate previsaoDevolucao;
    private LocalDate dataDevolucao;
    private BigDecimal multa;
    private String observacao;

    public Emprestimo(Usuario usuario, Livro livro,
                      LocalDate dataEmprestimo, LocalDate previsaoDevolucao, String observacao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.previsaoDevolucao = previsaoDevolucao;
        this.observacao = observacao;
        this.multa = BigDecimal.ZERO;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public Livro getLivro() {
        return livro;
    }



    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }


    public LocalDate getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public void setPrevisaoDevolucao(LocalDate previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    public LocalDate getDevolucao() {
        return dataDevolucao;
    }

    public void setDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void aplicarMulta(BigDecimal valor) {
        this.multa = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "usuario=" + usuario +
                ", livro=" + livro +
                ", dataEmprestimo=" + dataEmprestimo +
                ", previsaoDevolucao=" + previsaoDevolucao +
                ", dataDevolucao=" + dataDevolucao +
                ", multa=" + multa +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
