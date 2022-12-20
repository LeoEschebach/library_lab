package library;
import java.util.*;

/**
 * 
 * @author Leo
 *
 */
public class Library {
	
	private ArrayList<Book> bookCollection;
	private String address;
	
	
	
	public Library(String address) {
		this.address = address;
		bookCollection  = new ArrayList<>();
	}
	
	public void addBook(Book newBook) {
		bookCollection.add(newBook);
	}
	
	public static void printOpeningHours() {
		System.out.println("All libraries are open 9 AM to 5 PM");
	}
	
	public void printAddress() {
		System.out.println(address);
	}
	public void returnBook(String bookTitle) {
		Book book = findBook(bookTitle);
		book.returned();
		System.out.println("You successfully returned " + bookTitle);
	}
	public Book findBook(String bookTitle) {
		Book book = null;
		for(int i = 0; i < bookCollection.size(); i++) {
			// Check whether this book is the one
			book = bookCollection.get(i);
			if(bookTitle.equals(book.getTitle())) {
				// Yes, it is the one
				break;	
			}
		}
		return book;
	}
	public void borrowBook(String bookTitle) {
		// Loop through books in library to find the one with bookTitle
		Book book = findBook(bookTitle);
		
		//checks if book is borrowed
		if(book == null) {
			System.out.println("Sorry, this book is not in our catalog.");
		}
		else if(book.isBorrowed()) {
			System.out.println("Sorry, this book is already borrowed");
		}
		else {
			book.borrowed();
			System.out.println("You successfully borrowed " + bookTitle);
		}
		
		
	}
	public void printAvailableBooks() {
		if(bookCollection.size() == 0) {
			System.out.println("No books in catalog.");
		}
		else {
			for(int i = 0; i < bookCollection.size(); i++) {
				if(!bookCollection.get(i).isBorrowed()) {
					System.out.println(bookCollection.get(i).getTitle());
				}
			}
		}
    }
    public static void main(String[] args) {
    	Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 