package com.vantage.assesment.repository;

import com.vantage.assesment.entity.Review;
import com.vantage.assesment.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Md. Tanver Ahammed
 */

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByTopic(Topic topic);

    List<Review> findAllByDate(String date);

}
