package com.example.kineticstestproblemsolver.services;

import com.example.kineticstestproblemsolver.models.Employee;
import com.example.kineticstestproblemsolver.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByFullName(String fullName) {
        return employeeRepository.findByFullName(fullName);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    public Employee getEmployeeByRank(String rank) {
        return employeeRepository.findByRank(rank);
    }

    public Employee getEmployeeByIIN(String IIN) {
        return employeeRepository.findByIIN(IIN);
    }

    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}