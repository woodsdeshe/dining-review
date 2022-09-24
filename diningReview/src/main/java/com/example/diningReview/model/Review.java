package com.example.diningReview.model;

public class Review {

private int reviewId;
private String name;
private double starRating;
private String cuisineType;
private boolean acceptsCreditCards;
private String neighborhood;
private String foodCost;
private boolean hasOutdoorSeating;

        public Review() {

        }


        public int getReviewId() {
        return reviewId;
        }

public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
        }

public String getName() {
        return name;
        }

public void setName(String name) {
        this.name = name;
        }

public double getStarRating() {
        return starRating;
        }

public void setStarRating(double starRating) {
        this.starRating = starRating;
        }

public String getCuisineType() {
        return cuisineType;
        }

public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
        }

public boolean isAcceptsCreditCards() {
        return acceptsCreditCards;
        }

public void setAcceptsCreditCards(boolean acceptsCreditCards) {
        this.acceptsCreditCards = acceptsCreditCards;
        }

public String getNeighborhood() {
        return neighborhood;
        }

public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        }

public String getFoodCost() {
        return foodCost;
        }

public void setFoodCost(String foodCost) {
        this.foodCost = foodCost;
        }

public boolean isHasOutdoorSeating() {
        return hasOutdoorSeating;
        }

public void setHasOutdoorSeating(boolean hasOutdoorSeating) {
        this.hasOutdoorSeating = hasOutdoorSeating;
        }

public Review(int restaurantId, String name, double starRating, String cuisineType, boolean acceptsCreditCards,
        String neighborhood, String foodCost, boolean hasOutdoorSeating) {
        this.reviewId = restaurantId;
        this.name = name;
        this.starRating = starRating;
        this.cuisineType = cuisineType;
        this.acceptsCreditCards = acceptsCreditCards;
        this.neighborhood = neighborhood;
        this.foodCost = foodCost;
        this.hasOutdoorSeating = hasOutdoorSeating;
        }

public Review(String name, double starRating, String cuisineType, boolean acceptsCreditCards,
        String neighborhood, String foodCost, boolean hasOutdoorSeating) {
        this(0, name, starRating, cuisineType, acceptsCreditCards, neighborhood, foodCost, hasOutdoorSeating);
        }

@Override
public String toString() {
        return "Review{" +
        "restaurantId=" + reviewId +
        ", name='" + name + '\'' +
        ", starRating=" + starRating +
        ", cuisineType='" + cuisineType + '\'' +
        ", acceptsCreditCards=" + acceptsCreditCards +
        ", neighborhood='" + neighborhood + '\'' +
        ", foodCost='" + foodCost + '\'' +
        ", hasOutdoorSeating=" + hasOutdoorSeating +
        '}';
        }
        }
