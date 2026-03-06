package com.joelk.forohub.domain.topic.validations.put;

import com.joelk.forohub.domain.topic.DataUpdateTopic;

public interface TopicUpdateValidator {
    void validate(DataUpdateTopic data, Long id);
}
