/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 * Name: Thanat Jumneanbun
 * Student number: 60843
 * Date: 16/10/2024
 * Lecturer’s name: Dr Nguyen Vo
 */
package LibraryManagementSystem;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private int ISBN;
    private boolean status;
    
    public Book(int bookID, String title, String author, int ISBN) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = true;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    public boolean checkAvailability() {
        return status;
    }
    
    public void borrowBook() {
        if (status) {
            status = false;
            System.out.println("The book \"" + title +"\" borrowed successfully.");
        } else {
            System.out.println("The book \"" + title +"\" is already borrowed.");
        }
    }
    
    public void returnBook() {
        if (!status) {
            status = true;
            System.out.println("The book \"" + title + "\" has been returned.");
        } else {
            System.out.println("The book \"" + title +"\" was not borrowed.");
        }
    }
    
    
    
    
    
}
