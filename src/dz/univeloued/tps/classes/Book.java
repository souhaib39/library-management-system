package dz.univeloued.tps.classes;

public class Book {
    private static int bookID=0;
    private String title;
    private String author;
    private String isbn;
    private boolean Available;

    public Book(String title, String author, String isbn) {
        bookID ++;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.Available = true;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean Available) {
        this.Available = Available;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "Book title " + title + " | Author " + author + " (" + (Available ? "Available" : "Loaned") + ")\n";
    }
}

