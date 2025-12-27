package api.hub.controller;

import api.hub.domain.topic.*;
import api.hub.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailDTO> register(@RequestBody @Valid TopicCreateDTO data, UriComponentsBuilder uriBuilder) {
        var author = userRepository.getReferenceById(data.authorId());
        var topic = new Topic(data, author);
        topicRepository.save(topic);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDetailDTO(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicSummaryDTO>> list(@PageableDefault(size = 10, sort = "date") Pageable pagination) {
        var page = topicRepository.findAll(pagination).map(TopicSummaryDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDTO> detail(@PathVariable Long id) {
        var topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDetailDTO(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDetailDTO> update(@PathVariable Long id, @RequestBody @Valid TopicUpdateDTO data) {
        var topic = topicRepository.getReferenceById(id);
        topic.updateData(data);
        return ResponseEntity.ok(new TopicDetailDTO(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var topic = topicRepository.getReferenceById(id);
        topicRepository.delete(topic);
        return ResponseEntity.noContent().build();
    }
}