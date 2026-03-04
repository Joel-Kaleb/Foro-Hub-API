package com.joelk.forohub.controller;

import com.joelk.forohub.domain.topic.DataRegistrationTopic;
import com.joelk.forohub.domain.topic.ListDataTopic;
import com.joelk.forohub.domain.topic.TopicService;
import org.springframework.data.domain.Page;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<ListDataTopic>> sendAllTopics(@PageableDefault(size = 10, sort = {"createdAt"}) Pageable pageable) {
        var page = topicService.getAllTopics(pageable);
        return ResponseEntity.ok(page);
    }
}
