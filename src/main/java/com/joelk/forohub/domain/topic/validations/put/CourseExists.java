package com.joelk.forohub.domain.topic.validations.put;

import com.joelk.forohub.domain.ValidationException;
import com.joelk.forohub.domain.course.CourseRepository;
import com.joelk.forohub.domain.topic.DataUpdateTopic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseExists implements TopicUpdateValidator {

    private final CourseRepository repository;

    @Override
    public void validate(DataUpdateTopic data, Long id) {
        if (data.courseId() != null) {
            if (!repository.existsById(data.courseId())) {
                throw new ValidationException("The specified course does not exist.");
            }
        }
    }
}
