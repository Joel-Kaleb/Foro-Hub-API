package com.joelk.forohub.domain.topic.validations.put;

import com.joelk.forohub.domain.ValidationException;
import com.joelk.forohub.domain.topic.DataUpdateTopic;
import com.joelk.forohub.domain.topic.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DuplicateMessageOrTitle implements TopicUpdateValidator{
    private final TopicRepository repository;

    @Override
    public void validate(DataUpdateTopic data, Long id) {
        if (data.title() != null && data.message() != null) {
            boolean isDuplicate = repository.existsByTitleAndMessageAndIdNot(data.title(), data.message(), id);

            if (isDuplicate) {
                throw new ValidationException("Another topic already has the same title and message.");
            }
        }
    }
}
