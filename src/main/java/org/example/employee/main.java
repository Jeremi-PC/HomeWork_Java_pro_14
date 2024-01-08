package org.example.employee;

import org.example.employee.emploteeClasses.Employee;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        try {
            employee.writeEmployeeToFile("test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
