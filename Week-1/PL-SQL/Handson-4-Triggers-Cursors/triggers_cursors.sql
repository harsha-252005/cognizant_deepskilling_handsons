-- ============================================================
-- Handson-4: PL/SQL Triggers & Cursors
-- ============================================================

-- Audit table for salary changes
CREATE TABLE salary_audit (
    audit_id   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    emp_id     NUMBER,
    old_salary NUMBER(10,2),
    new_salary NUMBER(10,2),
    changed_on DATE DEFAULT SYSDATE,
    changed_by VARCHAR2(50) DEFAULT USER
);

-- Trigger: Log every salary change
CREATE OR REPLACE TRIGGER trg_salary_audit
AFTER UPDATE OF salary ON employees
FOR EACH ROW
BEGIN
    INSERT INTO salary_audit (emp_id, old_salary, new_salary)
    VALUES (:OLD.emp_id, :OLD.salary, :NEW.salary);
END;
/

-- Cursor: Iterate over all employees and print salary info
DECLARE
    CURSOR emp_cursor IS
        SELECT emp_id, first_name, salary FROM employees ORDER BY salary DESC;
    v_emp emp_cursor%ROWTYPE;
BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO v_emp;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_emp.first_name || ' earns $' || v_emp.salary);
    END LOOP;
    CLOSE emp_cursor;
END;
/
