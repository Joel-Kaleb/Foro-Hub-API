package com.joelk.forohub.controller;

import com.joelk.forohub.domain.topic.DataRegistrationTopic;
import com.joelk.forohub.domain.topic.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public ResponseEntity newTopic(@RequestBody @Valid DataRegistrationTopic data, UriComponentsBuilder uriBuilder) {
        var response = topicService.createNewTopic(data);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
