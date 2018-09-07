INSERT INTO dishes(dish_name, dish_description, dish_composition, dish_category, dish_amount, dish_rating)
VALUES('Dish name', 'Dish description', 'Dish composition', 'Dish category', 250, 4);

INSERT INTO users(user_email, user_password, user_role, user_first_name, user_last_name, user_date_of_birthday)
VALUES('user@gmail.com', '123', 'USER', 'Firstname', 'Lastname', '1991-05-07');

INSERT INTO orders(order_date, order_cooker, order_status, dish_id, user_id)
VALUES('2018-02-15', 'Order cooker', 'Order status', 1, 1);

INSERT INTO comments(comment_date, comment_text, comment_rating, dish_id, user_id)
VALUES('2018-06-15', 'Comment text', 3, 1, 1);