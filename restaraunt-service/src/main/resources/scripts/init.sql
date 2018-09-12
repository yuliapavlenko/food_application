CREATE TABLE dishes(
  dish_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dish_name VARCHAR(255) NOT NULL,
  dish_description VARCHAR(255),
  dish_composition VARCHAR(255) NOT NULL,
  dish_category VARCHAR(255) NOT NULL,
  dish_amount DOUBLE,
  dish_rating DOUBLE,
  dish_photo VARCHAR(20000)
);

CREATE TABLE users(
  user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_email VARCHAR(255) NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  user_role VARCHAR(255) NOT NULL,
  user_first_name VARCHAR(255) NOT NULL,
  user_last_name VARCHAR(255) NOT NULL,
  user_date_of_birthday TIMESTAMP,
  user_photo VARCHAR(20000)
);

CREATE TABLE orders(
  order_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  order_date TIMESTAMP NOT NULL,
  order_cooker VARCHAR(255),
  order_status VARCHAR(255) NOT NULL,
  dish_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  CONSTRAINT FK_DishOrder FOREIGN KEY (dish_id) REFERENCES dishes(dish_id),
  CONSTRAINT FK_UserOrder FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE comments(
  comment_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  comment_date TIMESTAMP NOT NULL,
  comment_text VARCHAR(255) NOT NULL,
  comment_rating DOUBLE,
  dish_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  CONSTRAINT FK_DishComment FOREIGN KEY (dish_id) REFERENCES dishes(dish_id),
  CONSTRAINT FK_UserComment FOREIGN KEY (user_id) REFERENCES users(user_id)
);