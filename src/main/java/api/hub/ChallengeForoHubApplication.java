package api.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ChallengeForoHubApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChallengeForoHubApplication.class, args);

        // ESTA LÍNEA GENERARÁ TU CONTRASEÑA REAL
        System.out.println(">>> USA ESTE HASH EN MYSQL PARA '123456': " + new BCryptPasswordEncoder().encode("123456"));
    }
}