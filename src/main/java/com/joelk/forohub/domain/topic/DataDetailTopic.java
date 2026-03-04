package com.joelk.forohub.domain.topic;

import java.time.LocalDateTime;

public record DataDetailTopic(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        String authorName,
        String courseName
) {
    public DataDetailTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreatedAt(),
                topic.getAuthor().getName(), topic.getCourse().getName());
    }
}
