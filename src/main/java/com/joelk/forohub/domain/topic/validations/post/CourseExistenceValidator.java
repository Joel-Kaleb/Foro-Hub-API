package com.joelk.forohub.domain.topic.validations.post;

import com.joelk.forohub.domain.course.CourseRepository;
import com.joelk.forohub.domain.topic.DataRegistrationTopic;
import com.joelk.forohub.domain.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseExistenceValidator implements TopicValidation{

    private final CourseRepository repository;

    @Override
    public void validation(DataRegistrationTopic data) {
        if(!repository.existsById(data.courseId())) {
            throw new ValidationException("The specified course does not exist.");
        }
    }
}
