package api.hub.controller;

import api.hub.domain.user.DataAuthenticationUser;
import api.hub.domain.user.User;
import api.hub.infra.security.JWTTokenDTO;
import api.hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid DataAuthenticationUser data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var jwtToken = tokenService.generarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDTO(jwtToken));
    }
}