package com.philipecarvalho.exercicioelevador.exception;

public class TerreoException extends RuntimeException {
    public TerreoException() {
        super("Estamos no térreo! Não é possível descer mais.");
    }
    public TerreoException(String message) {
        super(message);
    }
}
