package dz.univeloued.tps.classes;

public class E_book extends Book{
    private String downloadLink;  //Download Link
    private double fileSize; //file size in MB

    public E_book(String title, String author, String isbn, String link, double size) {
        super(title,author,isbn);  // Call the constructor of the parent class
        this.downloadLink = link;
        this.fileSize = size;
    }

    @Override
    public String toString() {
        return super.toString().trim() + "Type: E-Book | Size: " + fileSize + "MB | Download link:" + downloadLink;
    }
}
