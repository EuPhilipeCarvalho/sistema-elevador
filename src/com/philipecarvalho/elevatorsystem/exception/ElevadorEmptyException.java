package com.philipecarvalho.elevatorsystem.exception;

public class ElevadorEmptyException extends RuntimeException {
    public ElevadorEmptyException() {
        super("Elevador vazio! Não há ninguém para sair.");
    }
    public ElevadorEmptyException(String message) {
        super(message);
    }
}
