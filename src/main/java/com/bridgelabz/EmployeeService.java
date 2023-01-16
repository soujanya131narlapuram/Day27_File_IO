
package com.bridgelabz;

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

        // Check if directory exists
        if (directory.exists()) {
            System.out.println("Directory " + directoryName + " already exists.");
        } else {
            // Create directory
            if (directory.mkdir()) {
                System.out.println("Directory " + directoryName + " created.");
            } else {
                System.out.println("Failed to create directory " + directoryName);
            }
        }

        File file = new File(directoryName + "/" + fileName);

        // Check if file exists
        if (file.exists()) {
            System.out.println("File " + fileName + " already exists.");
        } else {
            // Create empty file
            if (file.createNewFile()) {
                System.out.println("File " + fileName + " created.");
            } else {
                System.out.println("Failed to create file " + fileName);
            }
        }

        // Delete file and check if it doesn't exist
        if (file.delete()) {
            if (!file.exists()) {
                System.out.println("File " + fileName + " deleted and no longer exists.");
            }
        } else {
            System.out.println("Failed to delete file " + fileName);
        }

        // List files and directories
        File[] files = directory.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }

        // List files with a specific extension
        String extension = "txt";
        for (File f : files) {
            if (f.getName().endsWith("." + extension)) {
                System.out.println(f.getName());
            }
        }
    }

}
