package com.joelk.forohub.domain.user;

import com.joelk.forohub.domain.user.validations.post.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final List<UserValidator> userValidatorList;

    @Transactional
    public DataDetailUser createNewUser(DataRegistrationUser data) {
        userValidatorList.forEach(v -> v.validate(data));

        var hashedPassword = passwordEncoder.encode(data.password());

        var user = new User(data, hashedPassword);

        userRepository.save(user);

        return new DataDetailUser(user);
    }
}
