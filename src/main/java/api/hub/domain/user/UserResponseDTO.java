package api.hub.domain.user;

public record UserResponseDTO(Long id, String name, String email, String login) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getLogin());
    }
}