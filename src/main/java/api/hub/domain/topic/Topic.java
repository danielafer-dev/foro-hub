package api.hub.domain.topic;

import api.hub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;

    @Column(name = "date")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private TopicStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    private String course;

    // ... (resto de la clase)
    public Topic(TopicCreateDTO data, User author) {
        this.title = data.title();     // Línea 46: Debe coincidir con el Record
        this.message = data.message(); // Línea 47: Debe coincidir con el Record
        this.date = LocalDateTime.now();
        this.status = TopicStatus.OPEN;
        this.author = author;
        this.course = data.course();

    }

    public void updateData(TopicUpdateDTO data) {
        if (data.title() != null) { this.title = data.title(); }
        if (data.message() != null) { this.message = data.message(); }
    }
}