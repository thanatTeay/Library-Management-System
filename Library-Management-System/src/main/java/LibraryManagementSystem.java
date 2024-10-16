
import LibraryManagementSystem.Book;
import LibraryManagementSystem.Library;
import LibraryManagementSystem.Loan;
import LibraryManagementSystem.Patron;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author admin
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("Central Library");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Patron");
            System.out.println("4. Issue Loan");
            System.out.println("5. Return Book");
            System.out.println("6. Check Book Availability");
            System.out.println("7. Check Due Date");
            System.out.println("8. Display Books");
            System.out.println("9. Display Patrons");
            System.out.println("10. Display Loans");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    int ISBN = scanner.nextInt();
                    Book newBook = new Book(bookID, title, author, ISBN);
                    library.addBook(newBook);
                    break;
                case 2:
                    // Remove a book
                    System.out.print("Enter book ID to remove: ");
                    int removeBookID = scanner.nextInt();
                    scanner.nextLine();
                    Book bookToRemove = null;
                    for (Book b : library.getBooks()) {
                        if (b.getBookID() == removeBookID) {
                            bookToRemove = b;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book with ID " + removeBookID + " not found.");
                    }
                    break;
                case 3:
                    // Register a patron
                    System.out.print("Enter patron ID: ");
                    int patronID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact info: ");
                    String contactInfo = scanner.nextLine();
                    Patron newPatron = new Patron(patronID, name, contactInfo);
                    library.registerPatron(newPatron);
                    break;
                case 4:
                    // Issue a loan
                    System.out.print("Enter patron ID: ");
                    int patronToIssueID = scanner.nextInt();
                    scanner.nextLine();
                    Patron patronToIssue = null;
                    for (Patron p : library.getPatrons()) {
                        if (p.getPatronID() == patronToIssueID) {
                            patronToIssue = p;
                            break;
                        }
                    }
                    if (patronToIssue != null) {
                        System.out.print("Enter book ID to borrow: ");
                        int bookToBorrowID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Book bookToBorrow = null;
                        for (Book b : library.getBooks()) {
                            if (b.getBookID() == bookToBorrowID) {
                                bookToBorrow = b;
                                break;
                            }
                        }
                        if (bookToBorrow != null) {
                            library.issueLoan(patronToIssue, bookToBorrow);
                        } else {
                            System.out.println("Book with ID " + bookToBorrowID + " not found.");
                        }
                    } else {
                        System.out.println("Patron with ID " + patronToIssueID + " not found.");
                    }
                    break;
                case 5:
                    // Return a book
                    System.out.print("Enter book ID to return: ");
                    int returnBookID = scanner.nextInt();
                    scanner.nextLine();
                    Book bookToReturn = null;
                    for (Book b : library.getBooks()) {
                        if (b.getBookID() == returnBookID) {
                            bookToReturn = b;
                            break;
                        }
                    }
                    if (bookToReturn != null) {
                        library.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book with ID " + returnBookID + " not found.");
                    }
                    break;
                case 6:
                    // Check book availability
                    System.out.print("Enter book ID to check availability: ");
                    int checkBookID = scanner.nextInt();
                    scanner.nextLine();
                    Book bookToCheck = null;
                    for (Book b : library.getBooks()) {
                        if (b.getBookID() == checkBookID) {
                            bookToCheck = b;
                            break;
                        }
                    }
                    if (bookToCheck != null) {
                        boolean isAvailable = bookToCheck.checkAvailability();
                        System.out.println("Book \"" + bookToCheck.getTitle() + "\" is "
                                + (isAvailable ? "available." : "currently borrowed."));
                    } else {
                        System.out.println("Book with ID " + checkBookID + " not found.");
                    }
                    break;
                case 7:
                    // Check due date for a borrowed book
                    System.out.print("Enter patron ID: ");
                    int patronToCheckID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Patron patronToCheck = null;
                    for (Patron p : library.getPatrons()) {
                        if (p.getPatronID() == patronToCheckID) {
                            patronToCheck = p;
                            break;
                        }
                    }
                    if (patronToCheck != null) {
                        System.out.print("Enter book ID to check due date: ");
                        int bookToCheckDueDateID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Book bookToCheckDueDate = null;
                        for (Book b : library.getBooks()) {
                            if (b.getBookID() == bookToCheckDueDateID) {
                                bookToCheckDueDate = b;
                                break;
                            }
                        }
                        if (bookToCheckDueDate != null) {
                            Date dueDate = patronToCheck.checkDueDate(bookToCheckDueDate);
                            if (dueDate != null) {
                                System.out.println("The due date for \"" + bookToCheckDueDate.getTitle() + "\" is " + dueDate);
                            } else {
                                System.out.println("The book is not borrowed by the patron.");
                            }
                        } else {
                            System.out.println("Book with ID " + bookToCheckDueDateID + " not found.");
                        }
                    } else {
                        System.out.println("Patron with ID " + patronToCheckID + " not found.");
                    }
                    break;
                case 8:
                    // Display all books
                    System.out.println("Books in the library:");
                    for (Book b : library.getBooks()) {
                        System.out.println("- " + b.getTitle() + " (Available: " + b.checkAvailability() + ")");
                    }
                    break;

                case 9:
                    // Display all patrons
                    System.out.println("Registered patrons:");
                    for (Patron p : library.getPatrons()) {
                        System.out.println("- " + p.getName());
                    }
                    break;

                case 10:
                    // Display all loans
                    System.out.println("Current loans:");
                    for (Loan l : library.getLoans()) {
                        System.out.println("- " + l.getBook().getTitle() + " borrowed by " + l.getPatron().getName() + ", due on " + l.getDueDate());
                    }
                    break;

                case 11:
                    running = false;
                    System.out.println("Exiting the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 7.");
                    break;
            }
        }
    }
}
