DELIMITER //

CREATE PROCEDURE IF NOT EXISTS InsertUsers(IN totalUsers INT)
BEGIN
    DECLARE counter INT DEFAULT 1;
    DECLARE userId INT;
    DECLARE userName VARCHAR(50);
    DECLARE email VARCHAR(100);

    -- Loop to generate and insert data into the user table
    WHILE counter <= totalUsers DO
            -- Generate random values for user data
            SET userName = CONCAT('User', counter);
            SET email = CONCAT('user', counter, '@example.com');

            -- Insert generated data into the user table
INSERT INTO user ( name, email)
VALUES (userName, email);

-- Increment the counter
SET counter = counter + 1;
END WHILE;
END //

DELIMITER ;

CALL InsertUsers(10); -- Insert data for 10 users