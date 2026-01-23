package com.philipecarvalho.exercicioelevador.exception;

public class GroundFloorException extends RuntimeException {
    public GroundFloorException() {
        super("Estamos no térreo! Não é possível descer mais.");
    }
    public GroundFloorException(String message) {
        super(message);
    }
}
