package com.vantage.assesment.controller;

import com.vantage.assesment.dto.ApiResponse;
import com.vantage.assesment.dto.TopicDTO;
import com.vantage.assesment.service.impl.TopicServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Md. Tanver Ahammed
 */

@RestController
@RequestMapping(path = "/topic")
public class TopicController {

    @Autowired
    private TopicServiceImpl topicService;

    // POST -> add topic
    @PostMapping(path = "/")
    public ResponseEntity<TopicDTO> addTopic(@Valid @RequestBody TopicDTO topicDTO) {
        return new ResponseEntity<>(this.topicService.addTopic(topicDTO), HttpStatus.CREATED);
    }

    // PUT -> update topic
    @PutMapping(path = "/{topicId}")
    public ResponseEntity<TopicDTO> updateTopic(@RequestBody TopicDTO topicDTO,
                                                @PathVariable("topicId") Long topicId) {
        return ResponseEntity.ok(this.topicService.updateTopic(topicDTO, topicId));
    }

    // GET -> get topic
    @GetMapping(path = "/{topicId}")
    public ResponseEntity<TopicDTO> getTopicById(@PathVariable("topicId") Long topicId) {
        return ResponseEntity.ok(this.topicService.getTopicByTopicId(topicId));
    }

    // get all
    @GetMapping(path = "/")
    public ResponseEntity<List<TopicDTO>> getAllTopics() {
        return ResponseEntity.ok(this.topicService.getAllTopic());
    }

    // DELETE -> delete topic
    @DeleteMapping("/{topicId}")
    public ResponseEntity<ApiResponse> deleteTopic(@PathVariable("topicId") Long topicId) {
        this.topicService.deleteTopic(topicId);
        return new ResponseEntity<>(new ApiResponse("Topic deleted successfully.", true),
                HttpStatus.OK);
    }

}
