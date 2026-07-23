-- ============================================================
-- Handson-3: PL/SQL Functions & Stored Procedures
-- ============================================================

-- Function: Calculate annual salary
CREATE OR REPLACE FUNCTION get_annual_salary(p_emp_id IN NUMBER)
RETURN NUMBER IS
    v_salary employees.salary%TYPE;
BEGIN
    SELECT salary INTO v_salary FROM employees WHERE emp_id = p_emp_id;
    RETURN v_salary * 12;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END get_annual_salary;
/

-- Test the function
SELECT get_annual_salary(1) AS annual_salary FROM DUAL;

-- Procedure: Give a raise to all employees in a department
CREATE OR REPLACE PROCEDURE give_raise(
    p_dept_id   IN NUMBER,
    p_percent   IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET    salary = salary * (1 + p_percent / 100)
    WHERE  dept_id = p_dept_id;

    DBMS_OUTPUT.PUT_LINE('Raise applied to dept ' || p_dept_id
        || '. Rows updated: ' || SQL%ROWCOUNT);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END give_raise;
/

-- Execute the procedure
BEGIN
    give_raise(10, 15);
END;
/
