package api.hub.domain.answer;

import java.time.LocalDateTime;

public record AnswerSummaryDTO(
        Long id,
        String message,
        LocalDateTime creationDate,
        String authorName,
        Boolean solution
) {
    public AnswerSummaryDTO(Answer answer) {
        this(
                answer.getId(),
                answer.getMessage(),
                answer.getCreationDate(),
                answer.getAuthor() != null ? answer.getAuthor().getName() : "Anonymous",
                answer.getSolution()
        );
    }
}