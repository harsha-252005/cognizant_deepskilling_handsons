-- ============================================================
-- Handson-5: PL/SQL Packages & Exception Handling
-- ============================================================

-- Package Specification
CREATE OR REPLACE PACKAGE emp_pkg AS
    PROCEDURE add_employee(
        p_id        IN NUMBER,
        p_first     IN VARCHAR2,
        p_last      IN VARCHAR2,
        p_email     IN VARCHAR2,
        p_salary    IN NUMBER,
        p_dept_id   IN NUMBER
    );
    FUNCTION get_employee_count(p_dept_id IN NUMBER) RETURN NUMBER;
END emp_pkg;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY emp_pkg AS

    PROCEDURE add_employee(
        p_id        IN NUMBER,
        p_first     IN VARCHAR2,
        p_last      IN VARCHAR2,
        p_email     IN VARCHAR2,
        p_salary    IN NUMBER,
        p_dept_id   IN NUMBER
    ) IS
    BEGIN
        INSERT INTO employees (emp_id, first_name, last_name, email, salary, dept_id)
        VALUES (p_id, p_first, p_last, p_email, p_salary, p_dept_id);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee ' || p_first || ' added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID or Email already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
    END add_employee;

    FUNCTION get_employee_count(p_dept_id IN NUMBER) RETURN NUMBER IS
        v_count NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_count FROM employees WHERE dept_id = p_dept_id;
        RETURN v_count;
    END get_employee_count;

END emp_pkg;
/

-- Usage
BEGIN
    emp_pkg.add_employee(5, 'Eve', 'Taylor', 'eve@company.com', 75000, 20);
    DBMS_OUTPUT.PUT_LINE('Dept 10 headcount: ' || emp_pkg.get_employee_count(10));
END;
/
