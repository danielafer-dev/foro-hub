package api.hub.domain.user;

public record UserSummaryDTO(Long id, String name, String email) {
    public UserSummaryDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}