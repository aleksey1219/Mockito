package com.example.mockito;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public double sum(int departId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == departId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
    public double maxSalary(int departId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == departId)
                .map(Employee::getSalary)
                .max(Comparator.comparingDouble(o -> o))
                .orElseThrow(() -> new RuntimeException());
    }
    public double minSalary(int departId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == departId)
                .map(Employee::getSalary)
                .min(Comparator.comparingDouble(o ->o))
                .orElseThrow(() -> new RuntimeException());
    }

    public List<Employee> findAllByDept(int departId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == departId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> groupByDept() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
