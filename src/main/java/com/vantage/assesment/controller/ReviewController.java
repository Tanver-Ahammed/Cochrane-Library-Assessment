package com.vantage.assesment.controller;

import com.vantage.assesment.dto.ApiResponse;
import com.vantage.assesment.dto.ReviewDTO;
import com.vantage.assesment.service.impl.ReviewServiceImpl;
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
@RequestMapping(path = "/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    // POST -> add review
    @PostMapping(path = "/{topicId}")
    public ResponseEntity<ReviewDTO> addReview(@Valid @RequestBody ReviewDTO reviewDTO,
                                               @PathVariable("topicId") Long topicId) {
        return new ResponseEntity<>(this.reviewService.addReview(reviewDTO, topicId), HttpStatus.CREATED);
    }

    // PUT -> update review
    @PutMapping(path = "/{reviewId}")
    public ResponseEntity<ReviewDTO> updateReview(@RequestBody ReviewDTO reviewDTO,
                                                  @PathVariable("reviewId") Long reviewId) {
        return ResponseEntity.ok(this.reviewService.updateReview(reviewDTO, reviewId));
    }

    // GET -> get review
    @GetMapping(path = "/{reviewId}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("reviewId") Long reviewId) {
        return ResponseEntity.ok(this.reviewService.getReviewByReviewId(reviewId));
    }

    // get all reviews
    @GetMapping(path = "/")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(this.reviewService.getAllReviews());
    }

    // get all reviews by topic id
    @GetMapping(path = "/topic/{topicId}")
    public ResponseEntity<List<ReviewDTO>> getAllReviewsByTopic(@PathVariable("topicId") Long topicId) {
        return ResponseEntity.ok(this.reviewService.getAllReviewsByTopic(topicId));
    }

    // DELETE -> delete review
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse> deleteReview(@PathVariable("reviewId") Long reviewId) {
        this.reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(new ApiResponse("Review deleted successfully.", true),
                HttpStatus.OK);
    }

}
