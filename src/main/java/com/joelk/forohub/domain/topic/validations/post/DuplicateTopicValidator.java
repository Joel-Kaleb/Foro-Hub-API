package com.joelk.forohub.domain.topic.validations.post;

import com.joelk.forohub.domain.ValidationException;
import com.joelk.forohub.domain.topic.DataRegistrationTopic;
import com.joelk.forohub.domain.topic.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DuplicateTopicValidator implements TopicValidation{

    private final TopicRepository repository;

    @Override
    public void validation(DataRegistrationTopic data) {
        boolean isDuplicate = repository.existsByTitleAndMessage(data.title(), data.message());

        if(isDuplicate) {
            throw new ValidationException("A topic with the same title and message already exists.");
        }
    }
}
