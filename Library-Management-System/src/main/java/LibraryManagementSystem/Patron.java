/**
 * @author 
 * Name: Thanat Jumneanbun
 * Student number: 60843
 * Date: 16/10/2024
 * Lecturer’s name: Dr Nguyen Vo
 */

package LibraryManagementSystem;

import LibraryManagementSystem.Book;
import java.util.ArrayList;
import java.util.Date;
public class Patron {
    private int patronID;
    private String name;
    private String contactInfo;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Loan> activeLoans;

    public Patron(int patronID, String name, String contactInfo) {
        this.patronID = patronID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
        this.activeLoans = new ArrayList<>();
    }

    public int getPatronID() {
        return patronID;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    
    public void borrowBook(Book book, Loan loan) {
        if (book.isStatus()) {
            book.borrowBook();
            borrowedBooks.add(book);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("This book was not borrowed by the patron.");
        }
    }
    
    public Date checkDueDate(Book book) {
        for (Loan loan : activeLoans) {
            if (loan.getBook().equals(book)) {
                return loan.getDueDate();
            }
        }
        System.out.println("The book \"" + book.getTitle() + "\" is not currently borrowed by " + name + ".");
        return null; // Return null if the book is not borrowed by this patron
    }
    
    
}
