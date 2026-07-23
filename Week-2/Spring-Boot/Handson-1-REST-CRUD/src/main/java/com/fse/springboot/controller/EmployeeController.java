package com.fse.springboot.controller;

import com.fse.springboot.dto.EmployeeDTO;
import com.fse.springboot.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EmployeeController — REST API for Employee CRUD operations.
 *
 * Base URL: /api/employees
 *
 * Endpoints:
 *   GET    /api/employees           → get all employees
 *   GET    /api/employees/{id}      → get employee by ID
 *   POST   /api/employees           → create new employee
 *   PUT    /api/employees/{id}      → update employee
 *   DELETE /api/employees/{id}      → delete employee
 *   GET    /api/employees/dept/{dept} → get by department
 */
@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "CRUD operations for Employee management")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new employee")
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing employee")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id,
                                               @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.updateEmployee(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employee")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dept/{department}")
    @Operation(summary = "Get employees by department")
    public ResponseEntity<List<EmployeeDTO>> getByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(service.getByDepartment(department));
    }
}
