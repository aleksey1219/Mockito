package com.example.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setup() {
        var employees = List.of(
                new Employee("tests", "tests" + "s", "asf", 1, 10),
                new Employee("testf", "tests" + "s", "asf", 2, 20),
                new Employee("testb", "tests" + "s", "asf", 3, 30),
                new Employee("testss", "tests" + "s", "asf", 1, 40),
                new Employee("testff", "tests" + "s", "asf", 2, 50),
                new Employee("testbb", "tests" + "s", "asf", 3, 60));
        when(employeeService.findAll()).thenReturn(employees);
    }

    @Test
    void sumTest() {
        Assertions.assertThat(departmentService.sum(1)).isEqualTo(50);
    }

    @Test
    void maxTest() {
        Assertions.assertThat(departmentService.maxSalary(1)).isEqualTo(40);
    }

    @Test
    void minTest() {
        Assertions.assertThat(departmentService.minSalary(3)).isEqualTo(30);
    }

    @Test
    void findAllByDeptTest() {
        var employ = departmentService.findAllByDept(2);
        Assertions.assertThat(employ.size()).isEqualTo(2);
        Assertions.assertThat(employ.get(0)).isEqualTo(new Employee("testf", "tests" + "s", "asf", 2, 20));
    }

    @Test
    void maxMinExcTest() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertThatThrownBy(() -> departmentService.maxSalary(1))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> departmentService.minSalary(1))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThat(departmentService.sum(1)).isEqualTo(0);
    }

    @Test
    void groupByDeptTest() {
        Map<Integer,List<Employee>> actual = departmentService.groupByDept();
        Assertions.assertThat(actual.keySet()).containsExactly(1, 2, 3);
        Assertions.assertThat(actual.get(1)).containsExactly(
                new Employee("tests", "tests" + "s", "asf", 1, 10),
                new Employee("testss", "tests" + "s", "asf", 1, 40));
        Assertions.assertThat(actual.get(2)).containsExactly(
                new Employee("testf", "tests" + "s", "asf", 2, 20),
                new Employee("testff", "tests" + "s", "asf", 2, 50));
        Assertions.assertThat(actual.get(3)).containsExactly(
                new Employee("testb", "tests" + "s", "asf", 3, 30),
                new Employee("testbb", "tests" + "s", "asf", 3, 60));
    }
}