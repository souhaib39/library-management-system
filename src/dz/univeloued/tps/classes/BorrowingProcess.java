package dz.univeloued.tps.classes;

import java.time.LocalDate;

public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowingProcess(Book book, Borrower borrower, int item) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
        this.returnDate = borrowDate.plusDays(item);  // Return date after the specified number of days
    }

    public String toString() {
        return "Book: " + book.getTitle()
                + " | Borrower: " + borrower.toString()
                + " | Borrow Date: " + borrowDate
                + " | Return: " + returnDate;
    }
}

