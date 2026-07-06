package com.gustavo.biblioteca.exception;

public class UsuarioNaoEcontradoException extends RuntimeException{

    public UsuarioNaoEcontradoException(String mensagem) {
        super(mensagem);
    }
}
