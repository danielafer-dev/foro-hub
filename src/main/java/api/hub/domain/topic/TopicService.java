package api.hub.domain.topic;

import api.hub.domain.user.UserRepository;
import api.hub.infra.errors.IntegrityValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    public TopicDetailDTO register(TopicCreateDTO data) { // Cambiado a 'register' y 'data'

        if (!userRepository.existsById(data.authorId())) { // Cambiado de autorId()
            throw new IntegrityValidationException("Author ID not found");
        }

        var author = userRepository.getReferenceById(data.authorId());

        // El constructor de Topic debe coincidir con estos nombres en inglés
        var topic = new Topic(
                null,
                data.title(),   // Antes titulo()
                data.message(), // Antes mensaje()
                null,
                null,
                author,
                data.course()   // Antes curso()
        );

        topicRepository.save(topic);

        return new TopicDetailDTO(topic);
    }
}