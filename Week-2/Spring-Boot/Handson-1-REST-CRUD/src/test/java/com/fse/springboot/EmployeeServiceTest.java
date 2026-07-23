package com.fse.springboot;

import com.fse.springboot.dto.EmployeeDTO;
import com.fse.springboot.entity.Employee;
import com.fse.springboot.exception.ResourceNotFoundException;
import com.fse.springboot.repository.EmployeeRepository;
import com.fse.springboot.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * EmployeeServiceTest — Unit tests for EmployeeService using Mockito.
 */
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    private Employee sampleEmployee;

    @BeforeEach
    void setUp() {
        sampleEmployee = new Employee("Alice", "Smith", "alice@test.com", "Engineering", 85000);
        sampleEmployee.setId(1L);
    }

    @Test
    void getAllEmployees_returnsListOfDTOs() {
        when(repository.findAll()).thenReturn(List.of(sampleEmployee));
        List<EmployeeDTO> result = service.getAllEmployees();
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getFirstName());
    }

    @Test
    void getEmployeeById_found_returnsDTO() {
        when(repository.findById(1L)).thenReturn(Optional.of(sampleEmployee));
        EmployeeDTO dto = service.getEmployeeById(1L);
        assertEquals("alice@test.com", dto.getEmail());
    }

    @Test
    void getEmployeeById_notFound_throwsException() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.getEmployeeById(99L));
    }

    @Test
    void createEmployee_savesAndReturnsDTO() {
        EmployeeDTO dto = new EmployeeDTO(null, "Bob", "Jones", "bob@test.com", "HR", 70000);
        Employee saved  = new Employee("Bob", "Jones", "bob@test.com", "HR", 70000);
        saved.setId(2L);
        when(repository.save(any(Employee.class))).thenReturn(saved);
        EmployeeDTO result = service.createEmployee(dto);
        assertEquals(2L, result.getId());
        assertEquals("Bob", result.getFirstName());
    }

    @Test
    void deleteEmployee_notFound_throwsException() {
        when(repository.existsById(99L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> service.deleteEmployee(99L));
    }
}
