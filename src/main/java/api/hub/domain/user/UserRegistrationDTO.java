package api.hub.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String login,
        @NotBlank String password
) {}