package api.hub.infra.errors;

public class IntegrityValidationException extends RuntimeException {

    public IntegrityValidationException(String message) {
        super(message);
    }
}