package com.vantage.assesment.service.impl;

import com.vantage.assesment.dto.TopicDTO;
import com.vantage.assesment.entity.Topic;
import com.vantage.assesment.exception.ResourceNotFoundException;
import com.vantage.assesment.repository.TopicRepository;
import com.vantage.assesment.service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Md. Tanver Ahammed
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TopicDTO addTopic(TopicDTO topicDTO) {
        Topic topic = this.dtoToTopic(topicDTO);
        return this.topicToDTO(this.topicRepository.save(topic));
    }

    @Override
    public TopicDTO updateTopic(TopicDTO topicDTO, Long topicId) {
        Topic topic = this.getTopicById(topicId);
        topic.setTitle(topicDTO.getTitle());
        return this.topicToDTO(topic);
    }

    @Override
    public TopicDTO getTopicByTopicId(Long topicId) {
        return this.topicToDTO(this.getTopicById(topicId));
    }

    @Override
    public List<TopicDTO> getAllTopic() {
        return this.topicRepository
                .findAll()
                .stream()
                .map(this::topicToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTopic(Long topicId) {
        Topic topic = this.getTopicById(topicId);
        this.topicRepository.delete(topic);
    }

    // get topic by id
    public Topic getTopicById(Long topicId) {
        return this.topicRepository.findById(topicId).orElseThrow(() ->
                new ResourceNotFoundException("Topic", "id", topicId));
    }

    // topic to DTO
    public TopicDTO topicToDTO(Topic topic) {
        return this.modelMapper.map(topic, TopicDTO.class);
    }

    // dto to topic
    public Topic dtoToTopic(TopicDTO topicDTO) {
        return this.modelMapper.map(topicDTO, Topic.class);
    }

}
