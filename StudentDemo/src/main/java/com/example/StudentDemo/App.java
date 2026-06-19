package com.example.StudentDemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n Student Management System ");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Age");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Students s = new Students();

                    System.out.print("Enter Student ID: ");
                    s.setStudentId(sc.nextInt());
                    sc.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    s.setStudentName(sc.nextLine());
                    System.out.print("Enter Email: ");
                    s.setEmail(sc.nextLine());
                    System.out.print("Enter Course: ");
                    s.setCourse(sc.nextLine());
                    System.out.print("Enter Age: ");
                    s.setAge(sc.nextInt());
                    dao.save(s);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    List<Students> students = dao.findAll();

                    for (Students st : students) {
                        System.out.println(
                                st.getStudentId() + " " +
                                st.getStudentName() + " " +
                                st.getEmail() + " " +
                                st.getCourse() + " " +
                                st.getAge()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    Students updateStudent = new Students();
                    updateStudent.setStudentId(id);
                    System.out.print("Enter New Age: ");
                    updateStudent.setAge(sc.nextInt());
                    dao.update(updateStudent);
                    System.out.println("Student updated successfully.");
                    break;
                    
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.delete(deleteId);
                    System.out.println("Student deleted successfully.");
                    break;
                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}