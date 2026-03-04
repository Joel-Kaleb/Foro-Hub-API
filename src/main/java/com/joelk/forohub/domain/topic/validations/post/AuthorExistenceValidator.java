package com.joelk.forohub.domain.topic.validations.post;

import com.joelk.forohub.domain.topic.DataRegistrationTopic;
import com.joelk.forohub.domain.user.UserRepository;
import com.joelk.forohub.domain.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorExistenceValidator implements TopicValidation{

    private final UserRepository repository;

    @Override
    public void validation(DataRegistrationTopic data) {
        if (!repository.existsById(data.authorId())) {
            throw new ValidationException("The specified user does not exist.");
        }
    }
}
