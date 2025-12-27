package api.hub.domain.answer;

import api.hub.domain.topic.TopicRepository;
import api.hub.domain.user.UserRepository;
import api.hub.infra.errors.IntegrityValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    public AnswerSummaryDTO create(AnswerRequestDTO data) {
        // Verifica si el tópico existe usando topicId() del DTO
        if (!topicRepository.existsById(data.topicId())) {
            throw new IntegrityValidationException("Id de tópico no encontrado");
        }

        // Verifica si el autor existe usando authorId() del DTO
        if (!userRepository.existsById(data.authorId())) {
            throw new IntegrityValidationException("Id de usuario no encontrado");
        }

        var topic = topicRepository.getReferenceById(data.topicId());
        var author = userRepository.getReferenceById(data.authorId());

        // Crea la entidad Answer con los parámetros correctos
        var answer = new Answer(data.message(), topic, author);
        answerRepository.save(answer);

        return new AnswerSummaryDTO(answer);
    }
}