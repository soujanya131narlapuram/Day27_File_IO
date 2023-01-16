
package com.bridgelabz;

import java.io.FileWriter;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;


class EmployeePayrollService {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();

        System.out.print("Enter employee name: ");
        String name = scanner.next();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, salary);

        System.out.println("Employee Payroll Information: ");
        System.out.println("Id: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());

        String directoryName = "employee_payroll";
        String fileName = employee.getName() + ".txt";
        File directory = new File(directoryName);

        if(!directory.exists()){
            directory.mkdir();
        }

        File file = new File(directoryName + "/" + fileName);
        FileWriter fw = new FileWriter(file);
        fw.write(employee.getId() + "," + employee.getName() + "," + employee.getSalary());
        fw.close();

        int count = 0;
        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                count++;
                fileScanner.nextLine();
            }
            System.out.println("Number of entries in file: " + count);
            fileScanner.close();
        } else {
            System.out.println("File does not exist");
        }
    }


}
