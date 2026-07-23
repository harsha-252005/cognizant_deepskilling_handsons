package com.fse.springboot.service;

import com.fse.springboot.dto.EmployeeDTO;
import com.fse.springboot.entity.Employee;
import com.fse.springboot.exception.ResourceNotFoundException;
import com.fse.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * EmployeeService — Business logic layer.
 * Converts between Entity and DTO; delegates persistence to the repository.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return toDTO(emp);
    }

    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());
        return toDTO(repository.save(existing));
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public List<EmployeeDTO> getByDepartment(String department) {
        return repository.findByDepartment(department).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // --- Mapper helpers ---
    private EmployeeDTO toDTO(Employee e) {
        return new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastName(),
                e.getEmail(), e.getDepartment(), e.getSalary());
    }

    private Employee toEntity(EmployeeDTO dto) {
        return new Employee(dto.getFirstName(), dto.getLastName(),
                dto.getEmail(), dto.getDepartment(), dto.getSalary());
    }
}
