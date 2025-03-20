package com.example.kineticstestproblemsolver.repositories;

import com.example.kineticstestproblemsolver.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Find employees by full name
    List<Employee> findByFullName(String fullName);

    // Find employees by department
    List<Employee> findByDepartment(String department);

    // Find employees by position
    List<Employee> findByPosition(String position);

    // Find employees by rank
    Employee findByRank(String rank);

    // Find employees by IIN
    Employee findByIIN(String IIN);
}
