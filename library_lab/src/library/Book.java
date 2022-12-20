package library;

public class Book {

    private String title;
    private boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        title = bookTitle;
        borrowed = false;
        
    }
   
    // Marks the book as rented
    public void borrowed() {
    	if(borrowed) {
    		System.out.println("Sorry, this book is already borrowed.");
    	}
    	else {
    		borrowed = true;
    	}
    }
   
    
    /**
     * Marks the book as not rented
     */
    public void returned() {
    	if(!borrowed) { 
    		System.out.println("This book is already returned.");
    	}
    	else {
    		borrowed = false;
    	}
    }
   
    // Returns true if the book is rented, false otherwise
    /**
     * 
     * @return
     */
    public boolean isBorrowed() {
    	return borrowed;
    }
   
    // Returns the title of the book
    public String getTitle() {
        return title;
    }
    
}