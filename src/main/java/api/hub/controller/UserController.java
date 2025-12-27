package api.hub.controller;

import api.hub.domain.user.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserRegistrationDTO data, UriComponentsBuilder uriBuilder) {
        // Ahora el constructor User(data) funcionará correctamente
        var user = new User(data);
        userRepository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserResponseDTO(user));
    }
}