package api.hub.domain.answer;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AnswerUpdateDTO(
        @NotNull Long id,
        String solution,
        @NotNull Long usuario_Id,
        @NotNull Long topico_Id,
        LocalDateTime creationDate
) {
}