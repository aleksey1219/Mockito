package com.example.mockito;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private String name;
    private String lastName;
    private String patronymic;

    private int department;
    private int salary;


    public Employee(String name, String lastName, String patronymic, int department, int salary) {
        this.name = capitalize(name.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.patronymic = patronymic;
        if (department > 0 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("в компании всего пять отделов начиная с 1");
        }
        if (salary >= 0) {
            this.salary = salary;
        }
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }


    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDepartment(int department) {
        if (department > 0 && department <= 5) {

            this.department = department;
        }
        throw new IllegalArgumentException("в компании всего пять отделов начиная с 1");
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return  department == employee.department && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic,  department, salary);
    }

    @Override
    public String toString() {
        return "Employee{"   +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
