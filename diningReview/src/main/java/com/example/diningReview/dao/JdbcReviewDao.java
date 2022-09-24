package com.example.diningReview.dao;

import com.example.diningReview.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcReviewDao implements ReviewDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Review getReview(int reviewId) {
        Review review = null;
        String getReviewSql = "SELECT review_id, restaurant_name, star_rating, cuisine_type, accepts_credit_card, " +
                "neighborhood, food_cost, outdoor_seating FROM review WHERE review_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(getReviewSql, reviewId);

        if (results.next()) {
            review = mapRowToReview(results);
        }
        return review;
    }

    @Override
    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        String getReviewsListSql = "SELECT review_id, restaurant_name, star_rating, cuisine_type, accepts_credit_card, " +
                "neighborhood, food_cost, outdoor_seating " +
                "FROM review ORDER BY review_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(getReviewsListSql);

        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Review createReview(Review newReview) {
      String createReviewSql = "INSERT INTO review (restaurant_name, star_rating, cuisine_type, accepts_credit_card," +
              "neighborhood, food_cost, outdoor_seating) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING review_id;";
      int newId = jdbcTemplate.queryForObject(createReviewSql, int.class, newReview.getName(), newReview.getStarRating(),
              newReview.getCuisineType(), newReview.getCuisineType(), newReview.isAcceptsCreditCards(), getReview().getNeighborhood(),
              newReview.getFoodCost(), getReview().isHasOutdoorSeating());
      return getReview(newId);
    }

    @Override
    public void updateReview(Review updatedReview) {
        String createReviewSql = "UPDATE review" +
                "SET restaurant_name = ?, star_rating = ?, cuisine_type = ?, accepts_credit_card = ?, neighborhood = ?," +
                "food_cost = ?, outdoor_seating = ? WHERE review_id = ?;";

        jdbcTemplate.update(createReviewSql, updatedReview.getName(), updatedReview.getStarRating(), updatedReview.getCuisineType(),
                updatedReview.isAcceptsCreditCards(), updatedReview.getNeighborhood(), updatedReview.getFoodCost(),
                updatedReview.isHasOutdoorSeating());
    }

    @Override
    public void deleteReview(int reviewId) {
    String deleteReviewSql = "DELETE FROM review WHERE review_id = ?;";
    jdbcTemplate.update(deleteReviewSql, reviewId);

    }

    private Review mapRowToReview(SqlRowSet results) {
        Review review = new Review();
        review.setReviewId(results.getInt("review_id"));
        review.setName(results.getString("restaurant_name"));
        review.setStarRating(results.getDouble("star_rating"));
        review.setCuisineType(results.getString("cuisine_type"));
        review.setAcceptsCreditCards(results.getBoolean("accepts_credit_card"));
        review.setNeighborhood(results.getString("neighborhood"));
        review.setFoodCost(results.getString("food_cost"));
        review.setHasOutdoorSeating(results.getBoolean("outdoor_seating"));
        return review;
    }
}
