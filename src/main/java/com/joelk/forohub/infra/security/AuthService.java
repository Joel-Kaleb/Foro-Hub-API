package com.joelk.forohub.infra.security;

import com.joelk.forohub.domain.user.DataAuthenticationUser;
import com.joelk.forohub.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public String login(DataAuthenticationUser data) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var usuarioAutenticado = authenticationManager.authenticate(authToken);

        return tokenService.generateToken((User) usuarioAutenticado.getPrincipal());
    }


}
