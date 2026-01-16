package com.philipecarvalho.exercicioelevador.exception;

public class UltimoAndarException extends RuntimeException {
    public UltimoAndarException() {
        super("Último andar já atingido! Não é possível subir mais.");
    }
    public UltimoAndarException(String message) {
        super(message);
    }
}
