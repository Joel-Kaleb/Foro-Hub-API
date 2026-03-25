package com.joelk.forohub.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public DataDetailUser createNewUser(DataRegistrationUser data) {
        var hashedPassword = passwordEncoder.encode(data.password());

        var user = new User(data, hashedPassword);

        userRepository.save(user);

        return new DataDetailUser(user);
    }
}
