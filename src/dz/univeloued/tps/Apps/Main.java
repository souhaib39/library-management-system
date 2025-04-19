package dz.univeloued.tps.Apps;

import dz.univeloued.tps.classes.*;
import dz.univeloued.tps.classes.role.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Borrower> borrowers = new ArrayList<>();
        ArrayList<BorrowingProcess> borrowings = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin(books, borrowers);
        User user = new User(books, borrowers, borrowings);

        System.out.println("\t \t Welcome to the Library System");
        System.out.print("Login as (1) Admin or (2) User: ");
        int role = Integer.parseInt(scanner.nextLine());

        if (role == 1) {
            runAdminMenu(admin, scanner);
        } else if (role == 2) {
            runUserMenu(user, scanner);
        } else {
            System.out.println("Invalid selection.");
        }

        scanner.close();
    }

    public static void runAdminMenu(Admin admin, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n Admin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Borrower");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. View All Borrowers");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    admin.addBook();
                    break;
                case 2:
                    admin.addBorrower();
                    break;
                case 3:
                    admin.returnBook();
                    break;
                case 4:
                    admin.viewBooks();
                    break;
                case 5:
                    admin.viewBorrowers();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    public static void runUserMenu(User user, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n  User Menu:");
            System.out.println("1. Search Book");
            System.out.println("2. Borrow Book (by ISBN)");
            System.out.println("3. View Borrowed Books");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    user.searchBook();
                    break;
                case 2:
                    user.borrowBookISBN();
                    break;
                case 3:
                    user.displayBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }
}
