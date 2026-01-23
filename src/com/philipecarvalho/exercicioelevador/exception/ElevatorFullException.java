package com.philipecarvalho.exercicioelevador.exception;

public class ElevatorFullException extends RuntimeException {
    public ElevatorFullException() {
        super("Elevador lotado! Não pode entrar mais pessoas.");
    }
    public ElevatorFullException(String message) {
        super(message);
    }
}
