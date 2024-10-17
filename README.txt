# Library Management System

This project is a Java-based Library Management System implemented using object-oriented programming principles. It allows users to manage a library's collection of books, register patrons, issue and return book loans, and track the availability and due dates of borrowed books through a command-line interface.

## Table of Contents
1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [How to Use](#how-to-use)
5. [Menu Options](#menu-options)


## Features
- **Add Book**: Add new books to the library's collection.
- **Remove Book**: Remove books from the library.
- **Register Patron**: Register new patrons who can borrow books from the library.
- **Issue Loan**: Issue books to registered patrons and track loan details.
- **Return Book**: Return books to the library and update loan records.
- **Check Book Availability**: Check if a book is available for borrowing.
- **Check Due Date**: Check the due date for a borrowed book.
- **Display Lists**: View lists of books, patrons, and active loans.

## Prerequisites
To run this project, ensure you have the following:
- **Java Development Kit (JDK) version 8 or higher**
- **NetBeans IDE** (optional, any Java-supported IDE can be used)

## Setup Instructions
Follow these steps to set up and run the program:

1. **Clone the repository** (if using version control):
   ```bash
   git clone https://github.com/thanatTeay/Library-Management-System.git
2. **Open Apache NetBeans IDE**
3. **Open file**

## How to Use
1. **Start the program:** When the program runs, you will see a menu with various options representing different actions you can perform in the library system.
2. **Choose an option** by entering the corresponding number for the desired action and pressing Enter. For example, to add a book, type 1 and press Enter.
3. **Follow the prompts:** Depending on the selected action, you may be asked to provide additional information, such as a book's ID, title, or patron's ID. Enter the requested information and press Enter.
4. **Continue using the program:** After completing an action, the menu will be displayed again. You can continue choosing options and performing different tasks.
5. **Exit the program:** To close the program, select the "Exit" option by typing 11 and pressing Enter.

## Menu Options
1. Add Book: Adds a new book to the library. You will be prompted to enter:
- Book ID (unique identifier for the book)
- Title (name of the book)
- Author (author's name)
- ISBN (International Standard Book Number)
2. Remove Book: Removes an existing book from the library using the book's ID. If the book is found, it will be removed; otherwise, an error message will be displayed.
3. Register Patron: Registers a new library patron. You will be asked to provide:
- Patron ID (unique identifier for the patron)
- Name (name of the patron)
- Contact Info (contact details, such as phone or email)
4. Issue Loan: Issues a book loan to a registered patron. You will need to provide:
- Patron ID (to identify the patron borrowing the book)
- Book ID (to identify the book being borrowed)
5. Return Book: Returns a borrowed book using its ID. The book will be marked as available in the system.
6. Check Book Availability: Checks whether a specific book is available for borrowing. You will be prompted to enter the book's ID, and the program will display the availability status.
7. Check Due Date: Checks the due date for a borrowed book. You will need to provide:
- Patron ID (to identify the borrower)
- Book ID (to identify the borrowed book)
8. Display Books: Lists all the books in the library, showing their titles and availability status.
9. Display Patrons: Lists all registered patrons in the library.
10. Display Loans: Displays all active loans, including the book title, borrower's name, and due date.
11. Exit: Exits the application.
