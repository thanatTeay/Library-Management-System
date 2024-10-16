/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import LibraryManagementSystem.Patron;
import LibraryManagementSystem.Loan;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Library {

    private String libraryName;
    private ArrayList<Book> books;
    private ArrayList<Patron> patrons;
    private ArrayList<Loan> loans;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(ArrayList<Patron> patrons) {
        this.patrons = patrons;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book \"" + book.getTitle() + "\" added!");
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("Book \"" + book.getTitle() + "\" removed!");
        } else {
            System.out.println("Book not found.");
        }

    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron registered.");
    }

    public void issueLoan(Patron patron, Book book) {
        if (!book.checkAvailability()) {
            System.out.println("Cannot issue loan. Book \"" + book.getTitle() + "\" is currently unavailable.");
            return; // Exit the method if the book is not available
        }

        int newLoanID = loans.size() + 1; // Generate a unique loan ID
        Loan newLoan = Loan.issueLoan(newLoanID, patron, book);

        if (newLoan != null) {
            loans.add(newLoan);
            System.out.println("Loan issued for \"" + book.getTitle() + "\" to " + patron.getName() + ". Due date: " + newLoan.getDueDate());
        } else {
            System.out.println("Failed to issue the loan for \"" + book.getTitle() + "\".");
        }
    }

    public void returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loan.getPatron().returnBook(book);
                loans.remove(loan);
                System.out.println("Book \"" + book.getTitle() + "\" has been returned.");
                return;
            }
        }
        System.out.println("The book \"" + book.getTitle() + "\" is not currently on loan.");
    }

}
