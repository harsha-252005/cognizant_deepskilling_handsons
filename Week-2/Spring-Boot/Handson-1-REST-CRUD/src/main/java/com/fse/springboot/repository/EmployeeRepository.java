package com.fse.springboot.repository;

import com.fse.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * EmployeeRepository — Spring Data JPA repository.
 * Provides CRUD operations out of the box via JpaRepository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(double salary);
}
