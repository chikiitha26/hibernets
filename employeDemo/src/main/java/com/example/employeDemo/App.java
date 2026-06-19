package com.example.employeDemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dep = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    float salary = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("Enter Joining Date (dd-mm-yyyy): ");
                    String joiningDate = sc.nextLine();

                    Employee emp = new Employee(
                            id,
                            name,
                            dep,
                            salary,
                            joiningDate
                    );

                    dao.save(emp);
                    System.out.println("Employee Saved Successfully!");
                    break;

                case 2:
                    List<Employee> employees = dao.findAll();

                    if (employees.isEmpty()) {
                        System.out.println("No Employees Found!");
                    } else {
                        System.out.println("\nEmployee Records");
                        System.out.println("--------------------------------------------------");

                        for (Employee e : employees) {
                            System.out.println(
                                    "ID: " + e.getEmployeeId()
                                    + ", Name: " + e.getEmployeeName()
                                    + ", Department: " + e.getDep()
                                    + ", Salary: " + e.getSalary()
                                    + ", Joining Date: " + e.getJoiningDate()
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();

                    Employee employee = dao.findById(id);

                    if (employee != null) {
                        System.out.println("\nEmployee Found");
                        System.out.println("ID: " + employee.getEmployeeId());
                        System.out.println("Name: " + employee.getEmployeeName());
                        System.out.println("Department: " + employee.getDep());
                        System.out.println("Salary: " + employee.getSalary());
                        System.out.println("Joining Date: " + employee.getJoiningDate());
                    } else {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Update: ");
                    id = sc.nextInt();

                    employee = dao.findById(id);

                    if (employee != null) {

                        sc.nextLine();

                        System.out.print("Enter New Employee Name: ");
                        employee.setEmployeeName(sc.nextLine());

                        System.out.print("Enter New Department: ");
                        employee.setDep(sc.nextLine());

                        System.out.print("Enter New Salary: ");
                        employee.setSalary(sc.nextFloat());
                        sc.nextLine();

                        System.out.print("Enter New Joining Date (dd-mm-yyyy): ");
                        employee.setJoiningDate(sc.nextLine());

                        dao.update(employee);

                        System.out.println("Employee Updated Successfully!");
                    } else {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Delete: ");
                    id = sc.nextInt();

                    dao.delete(id);
                    System.out.println("Employee Deleted Successfully!");
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}