package exercicioelevador.exception;

public class ElevadorVazioException extends RuntimeException {
    public ElevadorVazioException() {
        super("Elevador vazio! Não há ninguém para sair.");
    }
    public ElevadorVazioException(String message) {
        super(message);
    }
}
