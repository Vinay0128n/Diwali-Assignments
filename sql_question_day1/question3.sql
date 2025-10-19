DELIMITER //

CREATE PROCEDURE updateSalaryByWorkingDays(IN emp_id INT)
BEGIN

    DECLARE work_days INT;
    DECLARE current_salary DECIMAL(10,2);
    DECLARE new_salary DECIMAL(10,2);
    DECLARE join_date DATE;

    SELECT joining_date, salary INTO join_date, current_salary
    FROM employees
    WHERE id = emp_id;

    SET work_days = getWorkingDays(join_date);

    IF work_days > 250 THEN
        SET new_salary = current_salary * 1.15;
    ELSEIF work_days BETWEEN 200 AND 250 THEN
        SET new_salary = current_salary * 1.10;
    ELSEIF work_days BETWEEN 150 AND 199 THEN
        SET new_salary = current_salary * 1.05;
    ELSE
        SET new_salary = current_salary;
    END IF;

    UPDATE employees
    SET salary = new_salary
    WHERE id = emp_id;

END //

DELIMITER ;
