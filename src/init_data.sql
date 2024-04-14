-- Set a higher limit for group_concat to accommodate large inserts if needed
SET @@group_concat_max_len = 1000000;
-- Ensure safe mode is off to allow updates without WHERE
SET SQL_SAFE_UPDATES = 0;

-- ================================================================================================

-- Assuming the database is named 'your_database'
USE db_spring_2;

-- Insert 1000 products
DROP TEMPORARY TABLE IF EXISTS temp_products;
CREATE TEMPORARY TABLE temp_products (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(255),
                                         price DOUBLE,
                                         rating DOUBLE
);

INSERT INTO temp_products (name, price, rating)
SELECT CONCAT('Product ', a.id), RAND() * 100, 1 + (RAND() * 4)
FROM (
         SELECT 1 + a.a + b.a*10 + c.a*100 AS id
         FROM (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) a
                  CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) b
                  CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) c
     ) a
    LIMIT 1000;

INSERT INTO Product (name, price, rating)
SELECT name, price, rating FROM temp_products;

-- ================================================================================================
DROP TEMPORARY TABLE IF EXISTS temp_users;
CREATE TEMPORARY TABLE temp_users (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      email VARCHAR(255),
                                      password VARCHAR(255),
                                      firstName VARCHAR(255),
                                      lastName VARCHAR(255)
);

INSERT INTO temp_users (email, password, firstName, lastName)
SELECT CONCAT('user', a.id, '@example.com'), 'password', CONCAT('FirstName', a.id), CONCAT('LastName', a.id)
FROM (
         SELECT 1 + a.a + b.a*10 AS id
         FROM (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) a
                  CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) b
     ) a
    LIMIT 100;

INSERT INTO User (email, password, first_name, last_name)
SELECT email, password, firstName, lastName FROM temp_users;

-- ================================================================================================
-- Note: This will take a long time and might time out based on your settings; consider batching in smaller chunks if necessary
DROP TEMPORARY TABLE IF EXISTS temp_reviews;
CREATE TEMPORARY TABLE temp_reviews (
                                        comment TEXT,
                                        product_id INT,
                                        user_id INT
);

INSERT INTO temp_reviews (comment, product_id, user_id)
SELECT CONCAT('Review ', b.id, ' for product ', a.id), a.id, b.id
FROM temp_products a
         JOIN temp_users b
         CROSS JOIN (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10) c;

INSERT INTO Review (comment, product_id, user_id)
SELECT comment, product_id, user_id FROM temp_reviews;

-- ================================================================================================
