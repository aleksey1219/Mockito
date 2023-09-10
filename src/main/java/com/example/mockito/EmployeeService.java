package com.example.mockito;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmploee(String name, String lastName, String patronomic, int departament, int salary);
    Employee removeEmploee(String name, String lastName);
    Employee foundEmployee(String name, String lastName);
    Collection<Employee> findAll();

}
