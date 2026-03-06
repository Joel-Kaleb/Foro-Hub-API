package com.joelk.forohub.controller;

import com.joelk.forohub.domain.user.DataAuthenticationUser;
import com.joelk.forohub.domain.user.DataJWTToken;
import com.joelk.forohub.infra.security.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<DataJWTToken> autenticarUsuario(@RequestBody @Valid DataAuthenticationUser data) {
        var jwtToken = authService.login(data);
        return ResponseEntity.ok(new DataJWTToken(jwtToken));
    }
}
