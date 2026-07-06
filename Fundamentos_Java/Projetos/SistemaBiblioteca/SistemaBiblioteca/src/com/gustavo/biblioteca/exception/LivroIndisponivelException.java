package com.gustavo.biblioteca.exception;

public class LivroIndisponivelException extends RuntimeException {
    public LivroIndisponivelException(String mensage) {
        super(mensage);
    }
}
