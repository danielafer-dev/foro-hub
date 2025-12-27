package api.hub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record TopicRequestDTO(
        @NotBlank String title,   // Mapea a la columna 'title'
        @NotBlank String message, // Mapea a la columna 'message'
        @NotBlank String course   // Mapea a la columna 'course'
) {
}