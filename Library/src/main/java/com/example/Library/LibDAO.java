package com.example.Library;

import java.util.ArrayList;

public class LibDAO {

    private ArrayList<Lib> books = new ArrayList<>();

    // Add Book
    public void addBook(Lib book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // View All Books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Lib book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Available Copies: " + book.getAvailableCopies());
            System.out.println("-----------------------");
        }
    }


    public Lib searchBook(int id) {
        for (Lib book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

  
    public boolean deleteBook(int id) {
        Lib book = searchBook(id);

        if (book != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    
    public boolean updatePrice(int id, double price) {
        Lib book = searchBook(id);

        if (book != null) {
            book.setPrice(price);
            return true;
        }
        return false;
    }
}