package api.hub.domain.user.validation;

import api.hub.domain.user.UserRegistrationDTO;

public interface ValidadorDeUsuario {

    public void validate(UserRegistrationDTO UserRegistrationDTO);
}