package api.hub.infra.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IntegrityValidationException.class)
    public ResponseEntity errorHandlerValidacionesDeIntegridad(IntegrityValidationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // Aquí puedes tener otros manejadores como EntityNotFoundException, etc.
}