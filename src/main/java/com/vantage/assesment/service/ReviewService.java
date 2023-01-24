package com.vantage.assesment.service;

import com.vantage.assesment.dto.ReviewDTO;

import java.util.List;

/**
 * @Author: Md. Tanver Ahammed
 */

public interface ReviewService {

    ReviewDTO addReview(ReviewDTO reviewDTO, Long topicId);

    ReviewDTO updateReview(ReviewDTO reviewDTO, Long reviewId);

    ReviewDTO getReviewByReviewId(Long reviewId);

    List<ReviewDTO> getAllReviews();

    List<ReviewDTO> getAllReviewsByTopic(Long topicId);

    void deleteReview(Long reviewId);

}
