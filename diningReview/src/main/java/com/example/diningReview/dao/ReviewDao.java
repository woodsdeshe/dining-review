package com.example.diningReview.dao;

import com.example.diningReview.model.Review;

import java.util.List;

public interface ReviewDao {

    Review getReview(int reviewId);

    List<Review> getReviews();

    List<Review> getReviewsWithNoRating();

    Review createReview(Review newReview);

    void updateReview(Review updatedReview);

    void deleteReview(int reviewId);
}
