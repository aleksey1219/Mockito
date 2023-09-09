package com.example.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceImplTest {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        @Test
        void addEmploee() {
            employeeService.addEmploee("test", "tests", "Qfsa", 1, -10);
            Collection<Employee> allEmployees = employeeService.findAll();
            assertEquals(1, allEmployees.size());
            var employee = allEmployees.iterator().next();
            assertEquals("Test", employee.getName());
            assertEquals("Tests", employee.getLastName());
            assertEquals(0, employee.getSalary());

        }

        @Test
        void addEmpExs() {
            employeeService.addEmploee("test" + "s", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "f", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "b", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "nm", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "j", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "yl", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "bbf", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "oy", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "bui", "tests" + "s", "asf", 1, 23);
            employeeService.addEmploee("test" + "lui", "tests" + "s", "asf", 1, 23);
            assertThrows(Exs.class, () -> employeeService.addEmploee("test" + "s", "tests" + "s", "asf", 1, 23));
        }

        @Test
        void addEmpPovtorExs() {
            employeeService.addEmploee("test", "test", "test", 1, 1);
            assertThrows(RuntimeException.class, () -> employeeService.addEmploee("test", "test", "test", 1, 0));
        }

        @Test
        void addEmpDepartExs() {
            assertThrows(IllegalArgumentException.class, () -> employeeService.addEmploee("test", "test", "test", 0, 0));
        }

        @Test
        void removeEmploee() {
            employeeService.addEmploee("test", "tests", "Qfsa", 1, -10);
            assertEquals(1, employeeService.findAll().size());
            employeeService.removeEmploee("test", "tests");
            assertEquals(null, employeeService.removeEmploee("test", "tests"));
            assertEquals(0, employeeService.findAll().size());
        }

        @Test
        void foundEmployee() {
            employeeService.addEmploee("test", "tests", "Qfsa", 1, -10);
            employeeService.foundEmployee("test", "tests");
            Collection<Employee> allEmployees = employeeService.findAll();
            var employee = allEmployees.iterator().next();
            assertEquals("Test", employee.getName());
            assertEquals("Tests", employee.getLastName());
        }

        @Test
        void foundEmployeExs() {
            assertThrows(RuntimeException.class, () -> employeeService.foundEmployee("test", "tests"));
        }

        @Test
        void findAll() {
            employeeService.addEmploee("tests", "tests" , "asf", 1, 231);
            employeeService.addEmploee("testf", "tests" , "asf", 2, 232);
            employeeService.addEmploee("testb", "tests" ,"asf", 3, 233);
            var all = employeeService.findAll();
           // assertTrue(all.contains(new Employee("tests", "tests", "asf", 1, 231)));
           // assertTrue(all.contains(new Employee("testf", "tests", "asf", 2, 232)));
           // assertTrue(all.contains(new Employee("testb", "tests" ,"asf", 3, 233)));
            org.assertj.core.api.Assertions.assertThat(all).containsExactlyInAnyOrder(
                    new Employee("tests", "tests" , "asf", 1, 231),
                    new Employee("testf", "tests" , "asf", 2, 232),
                    new Employee("testb", "tests" , "asf", 3, 233));
}
}