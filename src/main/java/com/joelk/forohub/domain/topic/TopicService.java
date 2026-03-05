package com.joelk.forohub.domain.topic;

import com.joelk.forohub.domain.course.CourseRepository;
import com.joelk.forohub.domain.topic.validations.post.TopicValidation;
import com.joelk.forohub.domain.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    private final List<TopicValidation> validations;

    @Transactional
    public DataDetailTopic createNewTopic(DataRegistrationTopic data) {
        validations.forEach(v -> v.validation(data));

        var author = userRepository.getReferenceById(data.authorId());
        var course = courseRepository.getReferenceById(data.courseId());

        var topic = new Topic(data, author, course);

        topicRepository.save(topic);

        return new DataDetailTopic(topic);
    }

    public Page<ListDataTopic> getAllTopics(Pageable pagination) {
        return topicRepository.findAllByActiveTrue(pagination)
                .map(ListDataTopic::new);
    }

    public DataDetailTopic getTopicDetails(Long id) {
        var topic = topicRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found or is inactive"));

        return new DataDetailTopic(topic);
    }
}
