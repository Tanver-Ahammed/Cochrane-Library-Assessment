package com.vantage.assesment.service;

import com.vantage.assesment.dto.TopicDTO;

import java.util.List;

/**
 * @Author: Md. Tanver Ahammed
 */

public interface TopicService {

    TopicDTO addTopic(TopicDTO topicDTO);

    TopicDTO updateTopic(TopicDTO topicDTO, Long topicId);

    TopicDTO getTopicByTopicId(Long topicId);

    List<TopicDTO> getAllTopic();

    void deleteTopic(Long topicId);

}
