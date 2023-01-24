package com.vantage.assesment.repository;

import com.vantage.assesment.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Md. Tanver Ahammed
 * */

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
