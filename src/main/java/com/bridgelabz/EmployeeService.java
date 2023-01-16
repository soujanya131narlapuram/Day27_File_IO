
package com.bridgelabz;

import java.util.Scanner;

class EmployeePayrollService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of employees:");
        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the id of employee " + (i + 1));
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the name of employee " + (i + 1));
            String name = scanner.nextLine();
            System.out.println("Enter the salary of employee " + (i + 1));
            double salary = scanner.nextDouble();
            employees[i] = new Employee(id, name, salary);
        }

        System.out.println("Employee Payroll:");
        for (int i = 0; i < n; i++) {
            System.out.println("ID: " + employees[i].getId() + ", Name: " + employees[i].getName() + ", Salary: " + employees[i].getSalary());
        }
    }
}
