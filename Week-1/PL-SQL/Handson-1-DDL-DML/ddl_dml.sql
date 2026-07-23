-- ============================================================
-- Handson-1: PL/SQL DDL & DML
-- ============================================================

-- DDL: Create Tables
CREATE TABLE employees (
    emp_id     NUMBER PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name  VARCHAR2(50) NOT NULL,
    email      VARCHAR2(100) UNIQUE,
    salary     NUMBER(10,2),
    dept_id    NUMBER,
    hire_date  DATE DEFAULT SYSDATE
);

CREATE TABLE departments (
    dept_id   NUMBER PRIMARY KEY,
    dept_name VARCHAR2(100) NOT NULL,
    location  VARCHAR2(100)
);

-- DML: Insert Sample Data
INSERT INTO departments VALUES (10, 'Engineering', 'Bangalore');
INSERT INTO departments VALUES (20, 'Marketing',   'Mumbai');
INSERT INTO departments VALUES (30, 'HR',           'Delhi');

INSERT INTO employees VALUES (1, 'Alice',   'Smith',  'alice@company.com',  85000, 10, SYSDATE);
INSERT INTO employees VALUES (2, 'Bob',     'Jones',  'bob@company.com',    72000, 20, SYSDATE);
INSERT INTO employees VALUES (3, 'Charlie', 'Brown',  'charlie@company.com',90000, 10, SYSDATE);
INSERT INTO employees VALUES (4, 'Diana',   'Prince', 'diana@company.com',  68000, 30, SYSDATE);

COMMIT;

-- DML: Update & Delete
UPDATE employees SET salary = salary * 1.10 WHERE dept_id = 10;
DELETE FROM employees WHERE emp_id = 4;

COMMIT;

-- Query: Select with WHERE and ORDER BY
SELECT emp_id, first_name || ' ' || last_name AS full_name, salary
FROM   employees
WHERE  salary > 70000
ORDER  BY salary DESC;
