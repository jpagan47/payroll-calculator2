package com.pluralsight;

import java.io.*;

public class PayrollCalculator {
    public static void main(String[] args) {

        String inputFile = "src/main/resources/employees.csv";
        //Declaring my Reader
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println("You have ran into a File not found error");
            throw new RuntimeException(e);
        }
       bufferedReader = new BufferedReader(fileReader);

        //Declaring my Writer
        String fileName = "src/main/resources/payroll.csv";
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(fileName);
        } catch (IOException e) {
            System.err.println("You have ran into a Run Time Exception");
            throw new RuntimeException(e);
        }


        try {
            //Declaring my Reader

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine(); // Skip the first header line

            //Code will run while there is still a valid value in the following line
            while (line != null) {

                // Splitting up the line
                String[] parts = line.split("\\|");

                //Have to .parse from String
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                //Using Getters and Setters to declare
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setHoursWorked(hoursWorked);
                employee.setPayRate(payRate);

                //|ID|Name|GrossPay
                System.out.println("Gross pay for " + employee.getId() + " " + employee.getName() + "Is a total of " + employee.calculateGrossPay());

                //Writing in the student file "ID|Name|GrossPay"
                myWriter.write(employee.getId() + "\\|" + employee.getName() + "\\|" + employee.calculateGrossPay());
                myWriter.write("\n");

                //This allows for the reader to reset to the following line and back to the top
                line = bufferedReader.readLine();

            }
        } catch (IOException e) {
            System.err.println("You have ran into a Run Time Exception");
            throw new RuntimeException(e);
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            System.err.println("You have ran into a Run Time Exception");
            throw new RuntimeException(e);
        }
    }
}
