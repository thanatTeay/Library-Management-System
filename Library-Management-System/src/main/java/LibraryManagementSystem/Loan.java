/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagementSystem;

import java.util.Date;
import LibraryManagementSystem.Patron;
import LibraryManagementSystem.Book;

/**
 *
 * @author admin
 */
public class Loan {

    private int loanID;
    private Date loanDate;
    private Date dueDate;
    private Patron patron;
    private Book book;

    public Loan(int loanID, Date loanDate, Date dueDate, Patron patron, Book book) {
        this.loanID = loanID;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.patron = patron;
        this.book = book;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void extendLoan(int days) {
        long extraTime = days * 24L * 60 * 60 * 1000;
        dueDate = new Date(dueDate.getTime() + extraTime);
        System.out.println("The loan for \"" + book.getTitle() + "\" has been extended by " + days + " days.");
    }
    
    public static Loan issueLoan(int loanID, Patron patron, Book book) {
        // Check if the book is available
        if (!book.checkAvailability()) {
            System.out.println("The book \"" + book.getTitle() + "\" is currently unavailable.");
            return null; // Cannot issue a loan if the book is not available
        }

        // Set the loan and due dates
        Date loanDate = new Date(); // Current date
        Date dueDate = new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000); // Due in 7 days

        // Create a new loan
        Loan loan = new Loan(loanID, loanDate, dueDate, patron, book);

        // Update the patron's record to include the borrowed book and loan
        patron.borrowBook(book, loan);

        System.out.println("Loan issued for \"" + book.getTitle() + "\" to " + patron.getName() + ". Due date: " + dueDate);
        return loan;
    }

    public boolean calculateOverdue() {
        Date today = new Date();
        return today.after(dueDate);
    }
    
    public boolean checkLoanStatus() {
        return !calculateOverdue();
    }

}
