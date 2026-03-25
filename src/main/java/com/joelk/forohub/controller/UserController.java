package com.joelk.forohub.controller;

import com.joelk.forohub.domain.user.DataRegistrationUser;
import com.joelk.forohub.domain.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity newUser(@RequestBody @Valid DataRegistrationUser user, UriComponentsBuilder uriBuilder) {
        var response = userService.createNewUser(user);

        var uri = uriBuilder.path("/users/{id}/").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
