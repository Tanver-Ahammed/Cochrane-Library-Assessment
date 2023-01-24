package com.vantage.assesment.service.impl;

import com.vantage.assesment.dto.ReviewDTO;
import com.vantage.assesment.entity.Review;
import com.vantage.assesment.entity.Topic;
import com.vantage.assesment.exception.ResourceNotFoundException;
import com.vantage.assesment.repository.ReviewRepository;
import com.vantage.assesment.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Md. Tanver Ahammed
 */

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TopicServiceImpl topicService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ReviewDTO addReview(ReviewDTO reviewDTO, Long topicId) {
        Topic topic = this.topicService.getTopicById(topicId);
        Review review = this.dtoToReview(reviewDTO);
        review.setTopic(topic);
        return this.reviewToDTO(this.reviewRepository.save(review));
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO, Long reviewId) {
        Review review = this.getReviewById(reviewId);
        review.setTitle(reviewDTO.getTitle());
        review.setDate(reviewDTO.getDate());
        review.setAuthors(reviewDTO.getAuthors());
        review.setDetails(reviewDTO.getDetails());
        return this.reviewToDTO(this.reviewRepository.save(review));
    }

    @Override
    public ReviewDTO getReviewByReviewId(Long reviewId) {
        return this.reviewToDTO(this.getReviewById(reviewId));
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        return this.reviewRepository
                .findAll()
                .stream()
                .map(this::reviewToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getAllReviewsByTopic(Long topicId) {
        Topic topic = this.topicService.getTopicById(topicId);
        return this.reviewRepository
                .findAllByTopic(topic)
                .stream()
                .map(this::reviewToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReview(Long reviewId) {
        this.reviewRepository.delete(this.getReviewById(reviewId));
    }

    // get review by id
    public Review getReviewById(Long reviewId) {
        return this.reviewRepository.findById(reviewId).orElseThrow(() ->
                new ResourceNotFoundException("Review", "id", reviewId));
    }

    // review to DTO
    public ReviewDTO reviewToDTO(Review review) {
        return this.modelMapper.map(review, ReviewDTO.class);
    }

    // dto to review
    public Review dtoToReview(ReviewDTO reviewDTO) {
        return this.modelMapper.map(reviewDTO, Review.class);
    }

}
