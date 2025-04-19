package dz.univeloued.tps.classes.role;

import dz.univeloued.tps.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;
    Scanner scanner = new Scanner(System.in);

    public Admin(ArrayList<Book> books, ArrayList<Borrower> borrowers) {
        this.books = books;
        this.borrowers = borrowers;
    }

    //Add a Book
    public void addBook() {
        System.out.print("Book title: ");
        String title = scanner.nextLine();
        System.out.print("Book author:");
        String author = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Book type (1-paper / 2-electronic):");
        int type = Integer.parseInt(scanner.nextLine());

        if (type == 1) {
            System.out.print("Number of pages:");
            int pages = Integer.parseInt(scanner.nextLine());
            System.out.print("Storage place:");
            String location = scanner.nextLine();
            books.add(new PrintedBook(title, author, isbn, pages, location));
        } else if (type == 2) {
            System.out.print("File size (MB): ");
            double size = Double.parseDouble(scanner.nextLine());
            System.out.print("Download link: ");
            String link = scanner.nextLine();
            books.add(new E_book(title, author, isbn, link, size));
        } else {
            System.out.println("Invalid type!");
        }

        System.out.println("The book has been added successfully.\n");
    }

    //Add a Borrower
    public void addBorrower() {
        System.out.print("Borrower's name:");
        String name = scanner.nextLine();
        System.out.print("University number:");
        String id = scanner.nextLine();

        borrowers.add(new Borrower(name, id));
        System.out.println("The borrower was added successfully.\n");
    }

    //Return a book
    public void returnBook() {
        System.out.print("Enter borrower's university number: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrowerById(id);

        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        System.out.print("Enter book ISBN to return: ");
        String isbn = scanner.nextLine();
        Book book = findBookByIsbn(isbn);

        if (book == null || !borrower.getBorrowedBooks().contains(book)) {
            System.out.println("This borrower didn't borrow this book.");
            return;
        }

        borrower.removeBook(book);
        book.setAvailable(true);
        // Optional: remove from borrowings list

        System.out.println("Book returned successfully.");
    }

    //View All Borrowers
    public void viewBorrowers() {
        System.out.println("\n--- All Borrowers ---");
        for (Borrower b : borrowers) {
            System.out.println(b);
        }
    }

    //View All Books
    public void viewBooks() {
        System.out.println("\n--- All Books ---");
        for (Book book : books) {
            System.out.println(book);
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
