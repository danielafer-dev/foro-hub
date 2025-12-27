package api.hub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreateDTO(
        @NotBlank String title,    // Esto genera el método data.title()
        @NotBlank String message,  // Esto genera el método data.message()
        @NotBlank String course,   // Esto genera el método data.course()
        @NotNull Long authorId
) {
}