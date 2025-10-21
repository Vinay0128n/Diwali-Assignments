SELECT e1.dept_id, e1.emp_name, e1.salary
FROM employees e1
WHERE (
    SELECT COUNT(*)
    FROM employees e2
    WHERE e2.dept_id = e1.dept_id
      AND e2.salary > e1.salary
) < 5
ORDER BY e1.dept_id, e1.salary DESC;
