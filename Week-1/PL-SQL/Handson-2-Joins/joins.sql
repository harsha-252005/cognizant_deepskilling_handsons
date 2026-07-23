-- ============================================================
-- Handson-2: PL/SQL Joins
-- ============================================================

-- INNER JOIN: Employees with their department names
SELECT e.emp_id, e.first_name, e.last_name, d.dept_name, e.salary
FROM   employees e
INNER JOIN departments d ON e.dept_id = d.dept_id;

-- LEFT JOIN: All employees, including those without a department
SELECT e.emp_id, e.first_name, d.dept_name
FROM   employees e
LEFT JOIN departments d ON e.dept_id = d.dept_id;

-- RIGHT JOIN: All departments, including those with no employees
SELECT d.dept_name, e.first_name
FROM   employees e
RIGHT JOIN departments d ON e.dept_id = d.dept_id;

-- SELF JOIN: Find employees in the same department
SELECT a.first_name AS employee, b.first_name AS colleague, a.dept_id
FROM   employees a
JOIN   employees b ON a.dept_id = b.dept_id AND a.emp_id <> b.emp_id;

-- Aggregate with GROUP BY
SELECT d.dept_name, COUNT(e.emp_id) AS headcount, AVG(e.salary) AS avg_salary
FROM   departments d
LEFT JOIN employees e ON d.dept_id = e.dept_id
GROUP BY d.dept_name
HAVING COUNT(e.emp_id) > 0;
