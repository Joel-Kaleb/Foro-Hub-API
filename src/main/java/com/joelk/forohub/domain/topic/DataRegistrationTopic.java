package com.joelk.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegistrationTopic(
        @NotBlank String title,
        @NotBlank String message,
        @NotNull Long authorId,
        @NotNull Long courseId
) {
}
