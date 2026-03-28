package com.joelk.forohub.domain.user.validations.post;

import com.joelk.forohub.domain.ValidationException;
import com.joelk.forohub.domain.user.DataRegistrationUser;
import com.joelk.forohub.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DuplicateNameValidator implements UserValidator{

    private final UserRepository repository;

    @Override
    public void validate(DataRegistrationUser data) {
        if (repository.existsByName(data.name())) {
            throw new ValidationException("This name is already registered.");
        }
    }
}
