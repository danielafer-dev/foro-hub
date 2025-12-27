package api.hub.domain.topic;

public record TopicDetailDTO(Long id, String title, String message, String course) {
    public TopicDetailDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCourse());
    }
}