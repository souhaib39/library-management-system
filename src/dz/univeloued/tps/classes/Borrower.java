package dz.univeloued.tps.classes;

import java.util.ArrayList;

public class Borrower {
    private String name;
    private String universityId;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();  // List of borrowed books

    public Borrower(String name, String universityId) {
        this.name = name;
        this.universityId = universityId;
    }

    /**
     * Add a book to the borrowed books list
     *
     * @param book The borrowed book
     */

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Remove a book from the borrowed books list (upon return).
     *
     * @param book The returned book
     */

    public void removeBook(Book book) {
        borrowedBooks.remove(book);
    }

    /**
     * Retrieve a list of books borrowed by this borrower.
     *
     * @return List of borrowed books
     */

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getUniversityId() {
        return universityId;
    }

    public String toString() {
        return "Borrower's name: " + name + " (" + universityId + ")";
    }

}
