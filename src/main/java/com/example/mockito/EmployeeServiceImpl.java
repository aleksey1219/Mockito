package com.example.mockito;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final Map<String, Employee> employess;

    public EmployeeServiceImpl() {
        this.employess = new HashMap<>();
    }

    private static final int SIZE = 10;
    @PostConstruct
    private void init(){
        employess.put("ivan_ivanov", new Employee("Ivan", "Ivanov", "asfasf", 1, 24125));
        employess.put("Akakyi_ivanov", new Employee("Akakiy", "Ivanov", "asfasf", 1, 136516));
        employess.put("Egorivanov", new Employee("Egor", "Ivanov", "asfasf", 3, 351616));
        employess.put("Alekseyivanov", new Employee("Aleksey", "Glotov", "asfasf", 2, 35562));
    }

@Override
    public Employee addEmploee(String name, String lastName, String patronomic, int department, int salary) {
    if (employess.size() == SIZE) {
        throw new Exs("Сотрудники переполнены");
    }
    if (!valed(name, lastName)) {
        throw new InvaledInputException();
    }
    Employee employee = new Employee(name, lastName, patronomic, department, salary);
        String key = name + lastName;
        if ( employess.containsKey(key)) {
            throw new RuntimeException();
        }else {
            employess.put(key, employee);
        }
    return employee;
}
@Override
    public Employee removeEmploee(String name, String lastName) {
    if (!valed(name, lastName)) {
        throw new InvaledInputException();
    }
        String key = name  + lastName;
        if (employess.containsKey(key)) {
            employess.remove(key);
            System.out.println("Сотрудник удален: " + key);
        } else {
            System.out.println("Сотрудник не найден" + key);
        }
    return null;
}
@Override
    public Employee foundEmployee(String name, String lastName) {
    if (!valed(name, lastName)) {
        throw new InvaledInputException();
    }
        String key = name + lastName;
    if (employess.get(key) == null) {
        throw new RuntimeException("не найден");
    }
    return employess.get(key);
}

@Override
    public Collection<Employee> findAll() {

        return Collections.unmodifiableCollection(employess.values());
    }

    private boolean valed(String name, String lastName) {
        return isAlpha(name) && isAlpha(lastName);
    }
    }


