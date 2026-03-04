package com.joelk.forohub.domain.topic;

import java.time.LocalDateTime;

public record ListDataTopic(
    Long id,
    String title,
    String message,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    String author,
    String course
) {
    public ListDataTopic(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getUpdatedAt(),
                topic.getAuthor().getName(),
                topic.getCourse().getName()
        );
    }
}
