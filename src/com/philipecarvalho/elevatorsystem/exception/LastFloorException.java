package com.philipecarvalho.elevatorsystem.exception;

public class LastFloorException extends RuntimeException {
    public LastFloorException() {
        super("Último andar já atingido! Não é possível subir mais.");
    }
    public LastFloorException(String message) {
        super(message);
    }
}
