package org.example.employee.emploteeClasses;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//3 Создайте класс Сотрудник с полями имя, фамилия, дата рождения, должность,
// заработная плата. Сериализуйте объект и сохраните в файл.
// Поле заработной платы сериализовать не нужно, т.к. это коммерческая тайна организации.
public class Employee implements Serializable {
    String fname;
    String lname;
    LocalDate dateOfBirth;
    String position;
    transient Double salary;

    public Employee() {
        this.fname = "John";
        this.lname = "Bright";
        this.dateOfBirth = LocalDate.now();
        this.position = "Developer";
        this.salary = 20_000.0;
    }

    public void writeEmployeeToFile (String filename) throws IOException {


        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {

            try {
                output.writeObject(this);
                System.out.println("Object was serialized and save");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
