import java.util.ArrayList;

public class Library {
    ArrayList<Book> bookInLibrary = new ArrayList<Book>();


    public void addBook(Book bookInformation){
        bookInLibrary.add(bookInformation);
    }

}
