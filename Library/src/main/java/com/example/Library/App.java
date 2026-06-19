package com.example.Library;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Lib book = new Lib();

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Book Details");
            System.out.println("3. Update Price");
            System.out.println("4. Update Available Copies");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    book.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    book.setTitle(sc.nextLine());

                    System.out.print("Enter Author: ");
                    book.setAuthor(sc.nextLine());

                    System.out.print("Enter Price: ");
                    book.setPrice(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter Available Copies: ");
                    book.setAvailableCopies(sc.nextLine());

                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\nBook Details");
                    System.out.println("ID: " + book.getId());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Price: " + book.getPrice());
                    System.out.println("Available Copies: " + book.getAvailableCopies());
                    break;

                case 3:
                    System.out.print("Enter New Price: ");
                    book.setPrice(sc.nextDouble());
                    System.out.println("Price updated successfully!");
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter New Available Copies: ");
                    book.setAvailableCopies(sc.nextLine());
                    System.out.println("Copies updated successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}