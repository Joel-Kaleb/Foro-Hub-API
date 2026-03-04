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
}
