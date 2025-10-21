CREATE FUNCTION getWorkingDays(join_date DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total_days INT DEFAULT 0;
    DECLARE current_date DATE;

    SET current_date = join_date;
    WHILE current_date <= CURDATE() DO
        IF DAYOFWEEK(current_date) NOT IN (1,7) THEN
            SET total_days = total_days + 1;
        END IF;
        SET current_date = DATE_ADD(current_date, INTERVAL 1 DAY);
    END WHILE;

    RETURN total_days;
END //

DELIMITER ;
