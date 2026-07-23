package com.fse.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Employee — JPA Entity mapped to the EMPLOYEES table.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @Min(value = 0, message = "Salary must be non-negative")
    private double salary;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, String department, double salary) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.department = department;
        this.salary     = salary;
    }

    public Long getId()             { return id; }
    public String getFirstName()    { return firstName; }
    public String getLastName()     { return lastName; }
    public String getEmail()        { return email; }
    public String getDepartment()   { return department; }
    public double getSalary()       { return salary; }

    public void setId(Long id)                  { this.id = id; }
    public void setFirstName(String firstName)  { this.firstName = firstName; }
    public void setLastName(String lastName)    { this.lastName = lastName; }
    public void setEmail(String email)          { this.email = email; }
    public void setDepartment(String dept)      { this.department = dept; }
    public void setSalary(double salary)        { this.salary = salary; }
}
