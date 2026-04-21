package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        String file = "src/main/resources/employees.csv";
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();// Skip the first header line
            while (line != null) {

                // split up line
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setHoursWorked(hoursWorked);
                employee.setPayRate(payRate);

                // get name
                // create new employee object with correct name
                // print employee name

                line = bufferedReader.readLine();
                System.out.println("Gross pay for " + employee.getId() + " " + employee.getName() + "Is a total of " + employee.calculateGrossPay());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
