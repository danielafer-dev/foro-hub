package api.hub.domain.answer;

import api.hub.domain.topic.Topic;
import api.hub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "answers")
@Entity(name = "Answer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message; // Cambiado de 'mensaje'
    private LocalDateTime creationDate = LocalDateTime.now(); // Cambiado de 'fechaCreacion'

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id") // Cambiado de 'autor_id'
    private User author; // Cambiado de 'autor'

    private Boolean solution = false; // Cambiado de 'solucion'

    // Constructor para DTOs o servicios
    public Answer(String message, Topic topic, User author) {
        this.message = message;
        this.topic = topic;
        this.author = author;
        this.creationDate = LocalDateTime.now();
        this.solution = false;
    }
}