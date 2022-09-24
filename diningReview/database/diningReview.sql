BEGIN TRANSACTION;

DROP TABLE IF EXISTS review;

CREATE TABLE review (
	review_id serial,
	restaurant_name varchar(200) NOT NULL,
	star_rating decimal(2,1) NOT NULL,
	cuisine_type varchar(200) NOT NULL,
	accepts_credit_card boolean NOT NULL DEFAULT false,
	neighborhood varchar(200) NOT NULL,
	food_cost varchar(200) NOT NULL,
	outdoor_seating boolean NOT NULL DEFAULT false
);

INSERT INTO review (restaurant_name, star_rating, cuisine_type, accepts_credit_card, neighborhood, food_cost, outdoor_seating) VALUES
('Beer City Bread Co.', 3.5, 'Bakery', true, 'Northeast Grand Rapids', '$$', true),
('Real Food Cafe Eastern Ave', 4.0, 'Cafe', true, 'Eastern Ave', '$', false),
('Butcher’s Union', 3.9, 'Gastropub', true, 'Northwest Grand Rapids', '$$', true),
('Wolfgang’s Restaurant', 4.5, 'Breakfast', true, 'Southeast Grand Rapids', '$$', false),
('Leo’s Seafood Restaurant & Bar', 4.9, 'Seafood', true, 'Downtown Grand Rapids', '$$$', false),
('The Green Well', 3.8, 'New American', false, 'Southeast Grand Rapids', '$', true),
('San Chez a Tapas Bistro', 5.0, 'Spanish', true, 'Downtown Grand Rapids', '$$$', true);

COMMIT;