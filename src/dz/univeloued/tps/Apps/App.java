package dz.univeloued.tps.Apps;

import dz.univeloued.tps.classes.*;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App app = new App();

        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Borrower");
            System.out.println("3. Borrow a book by book title");
            System.out.println("4. Borrow a book by ISBN");
            System.out.println("5. Return a book");
            System.out.println("6. Search for a book");
            System.out.println("7. Search for a borrower");
            System.out.println("8. Display borrowed books");
            System.out.println("0. exit!");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    app.addBook();
                    break;
                case 2:
                    app.addBorrower();
                    break;
                case 3:
                    app.borrowBookTitle();
                    break;
                case 4:
                    app.borrowBookISBN();
                    break;
                case 5:
                    app.returnBook();
                    break;
                case 6:
                    app.searchBook();
                    break;
                case 7:
                    app.searchBorrower();
                    break;
                case 8:
                    app.displayBorrowedBooks();
                    break;
                case 0:
                    System.out.println("See you soon!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }


        }
    }

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Borrower> borrowers = new ArrayList<>();
    ArrayList<BorrowingProcess> borrowings = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    //Add a Book
    private void addBook() {
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
    private void addBorrower() {
        System.out.print("Borrower's name:");
        String name = scanner.nextLine();
        System.out.print("University number:");
        String id = scanner.nextLine();

        borrowers.add(new Borrower(name, id));
        System.out.println("The borrower was added successfully.\n");
    }

    //Borrow a book by Title
    private void borrowBookTitle() {
        System.out.print("Enter book title:");
        String title = scanner.nextLine();

        Book book = findBookByTitle(title);
        if (book == null || !book.isAvailable()) {
            System.out.println("The book is currently unavailable.");
            return;
        }

        System.out.print("Borrower's university number: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrowerById(id);

        if (borrower == null) {
            System.out.println("Borrower not present.\n");
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

    //Borrow a book by ISBN
    private void borrowBookISBN() {
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
        System.out.print("Number of days borrowed: ");
        int item = scanner.nextInt();
        scanner.nextLine();
        borrower.addBook(book);
        book.setAvailable(false);
        borrowings.add(new BorrowingProcess(book, borrower, item));

        System.out.println("The book has been loaned.\n");
    }

    //Return a book
    private void returnBook() {
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

    //Search for a book
    private void searchBook() {
        System.out.print("Enter title or ISBN to search: ");
        String input = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(input) || book.getIsbn().equals(input)) {
                System.out.println("Found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    //Search for a borrower
    private void searchBorrower() {
        System.out.print("Enter university number to search: ");
        String id = scanner.nextLine();

        Borrower borrower = findBorrowerById(id);
        if (borrower != null) {
            System.out.println("Found: " + borrower);
        } else {
            System.out.println("Borrower not found.");
        }
    }

    //Display borrowed books
    private void displayBorrowedBooks() {
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
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    private Borrower findBorrowerById(String id) {
        for (Borrower borrower : borrowers) {
            if (borrower.getUniversityId().equals(id)) return borrower;
        }
        return null;
    }
}