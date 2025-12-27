package api.hub.domain.answer;

import java.time.LocalDateTime;

/**
 * DTO para la respuesta detallada de una respuesta.
 * Soluciona los errores de "cannot find symbol" al usar nombres en inglés.
 */
public record AnswerResponseDTO(Long id, String message, LocalDateTime creationDate, String authorName) {
    public AnswerResponseDTO(Answer answer) {
        this(
                answer.getId(),
                answer.getMessage(), // Antes getMensaje()
                answer.getCreationDate(), // Antes getFechaCreacion()
                answer.getAuthor() != null ? answer.getAuthor().getName() : "Anonymous"
        );
    }
}