package com.example.mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RequestMapping("/department")
@RestController
public class DepartmentController  {
    private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{departId}/sum")
    public double sum(@PathVariable int departId) {
        return service.sum(departId);
    }
    @GetMapping("/{departId}/max-salary")
    public double maxSalary(@PathVariable int departId) {
        return service.maxSalary(departId);
    }
    @GetMapping("/{departId}/min-salary/")
    public double minSalary(@PathVariable int departId) {
        return service.minSalary(departId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> groupByDept() {
        return service.groupByDept();
    }
    @GetMapping("/{departId}/employees")
    public List<Employee> findAllByDept(@PathVariable int departId) {
        return service.findAllByDept(departId);
    }
}
