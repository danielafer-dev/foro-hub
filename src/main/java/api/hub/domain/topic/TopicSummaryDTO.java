package api.hub.domain.topic;

import java.time.LocalDateTime;

public record TopicSummaryDTO(Long id, String title, String message, LocalDateTime date, TopicStatus status, String course) {
    public TopicSummaryDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getDate(), topic.getStatus(), topic.getCourse());
    }
}