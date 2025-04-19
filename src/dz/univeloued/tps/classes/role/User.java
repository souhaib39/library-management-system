package dz.univeloued.tps.classes.role;

import java.util.*;

import dz.univeloued.tps.classes.*;

public class User {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;
    private ArrayList<BorrowingProcess> borrowings;
    Scanner scanner = new Scanner(System.in);

    public User(ArrayList<Book> books, ArrayList<Borrower> borrowers, ArrayList<BorrowingProcess> borrowings) {
        this.books = books;
        this.borrowers = borrowers;
        this.borrowings = borrowings;
    }


    //Search for a book
    public void searchBook() {
        System.out.print("Enter title or ISBN to search: ");
        String input = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(input) || book.getIsbn().equals(input)) {
                System.out.println("Found: " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }


    //Borrow a book by ISBN
    public void borrowBookISBN() {
        System.out.print("Book ISBN:");
        String isbn = scanner.nextLine();
        Book book = findBookByIsbn(isbn);

        if (book == null || !book.isAvailable()) {
            System.out.println("The book is not available.\n");
            return;
        }

        System.out.print("Borrower's university number: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrowerById(id);

        if (borrower == null) {
            System.out.println("Borrower not present.\n");
            return;
        }

        if (borrower.getBorrowedBooks().contains(book)) {
            System.out.println("This borrower already borrowed this book.");
            return;
        }

        System.out.print("Number of days borrowed: ");
        int item = scanner.nextInt();
        scanner.nextLine();
        borrower.addBook(book);
        book.setAvailable(false);
        borrowings.add(new BorrowingProcess(book, borrower, item));

        System.out.println("The book has been loaned.\n");
    }

    //Display borrowed books
    public void displayBorrowedBooks() {
        System.out.print("Enter borrower's university number: ");
        String id = scanner.nextLine();

        Borrower borrower = findBorrowerById(id);
        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        ArrayList<Book> borrowed = borrower.getBorrowedBooks();
        if (borrowed.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            System.out.println("Books borrowed by " + borrower + ":");
            for (Book book : borrowed) {
                System.out.println("- " + book);
            }
        }
    }

    //*******************************************************
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public Borrower findBorrowerById(String id) {
        for (Borrower borrower : borrowers) {
            if (borrower.getUniversityId().equals(id)) return borrower;
        }
        return null;
    }
}
