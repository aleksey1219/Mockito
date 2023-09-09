package com.example.mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/Employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String name,@RequestParam String lastName,@RequestParam String patronomic,@RequestParam int department,@RequestParam int salary) {
        return employeeService.addEmploee( name,  lastName,  patronomic,  department,  salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.removeEmploee(name,lastName);
    }
    @GetMapping("/found")
    public Employee found(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.foundEmployee(name, lastName);
    }
    @GetMapping("/all")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}
