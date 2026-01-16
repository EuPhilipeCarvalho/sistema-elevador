package com.philipecarvalho.exercicioelevador.exception;

public class ElevadorCheioException extends RuntimeException {
    public ElevadorCheioException() {
        super("Elevador lotado! Não pode entrar mais pessoas.");
    }
    public ElevadorCheioException(String message) {
        super(message);
    }
}
