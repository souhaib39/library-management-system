package dz.univeloued.tps.classes;

public class PrintedBook extends Book{
    private int numPag; //number Of Pages
    private String physicLoc;  //Storage location

    public PrintedBook(String title, String author, String isbn,int numPag,String physicLoc){
        super(title,author,isbn);  // Call the constructor of the parent class
        this.numPag = numPag;
        this.physicLoc = physicLoc;
    }

    @Override
    public String toString(){
        return super.toString().trim() + "Type: Paperback | Number of Pages: " + numPag + " | Storage Location: " + physicLoc ;
    }
}
