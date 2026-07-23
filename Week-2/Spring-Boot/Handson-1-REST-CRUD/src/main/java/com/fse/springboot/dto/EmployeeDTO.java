package com.fse.springboot.dto;

import jakarta.validation.constraints.*;

/**
 * EmployeeDTO — Data Transfer Object for Employee API requests/responses.
 * Keeps the API contract decoupled from the JPA entity.
 */
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @Min(value = 0, message = "Salary must be non-negative")
    private double salary;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String firstName, String lastName,
                       String email, String department, double salary) {
        this.id         = id;
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
