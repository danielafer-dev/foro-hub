package api.hub.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails findUserByEmail(String email) {
        // Buscamos por email porque es la columna que tienes en MySQL
        return userRepository.findByEmail(email);
    }
}