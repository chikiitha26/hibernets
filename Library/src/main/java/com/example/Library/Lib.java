package com.example.Library;

public class Lib {
	    private int id;
	    private String title;
	    private String author;
	    private double price;
	    private String availableCopies;
	    public Lib() {

	    }
	    public Lib(int id, String title, String author, double price, String availableCopies) {
	        this.id = id;
	        this.title = title;
	        this.author = author;
	        this.price = price;
	        this.availableCopies = availableCopies;
	    }
	    public int getId() {
	        return id;

	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getTitle() {
	        return title;
	    }
	   public void setTitle(String title) {
	        this.title = title;
	    }
	    public String getAuthor() {

	        return author;

	    }
	    public void setAuthor(String author) {

	        this.author = author;

	    }

	    public double getPrice() {

	        return price;

	    }



	    public void setPrice(double price) {

	        this.price = price;

	    }



	    public String getAvailableCopies() {

	        return availableCopies;

	    }



	    public void setAvailableCopies(String availableCopies) {

	        this.availableCopies = availableCopies;

	    }
}




	

