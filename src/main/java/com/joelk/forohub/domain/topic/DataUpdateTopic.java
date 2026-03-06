package com.joelk.forohub.domain.topic;

public record DataUpdateTopic(
        String title,
        String message,
        Long courseId,
        TopicStatus status
) { }
