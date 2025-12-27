package api.hub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserAuthDTO(
        @NotBlank String login,
        @NotBlank String password
) {}