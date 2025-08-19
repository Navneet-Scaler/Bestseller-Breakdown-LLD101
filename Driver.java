import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Driver {

    private static List<Book> dataset;

    public static void main(String[] args) {
        dataset = DatasetReader.readDataset("bestsellers.csv");
        System.out.println("Successfully loaded " + dataset.size() + " books.");
    }
    
    // Task 1) Function to count books by a given author
    public static void countBooksByAuthor(String authorName) {
        long count = 0;
        for (Book book : dataset) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        System.out.println("Author '" + authorName + "' has " + count + " book(s) in the bestseller list.");
    }

    // Task 2) Function to find all the author in dataset
    public static void printAllAuthors() {
        Set<String> authors = new HashSet<>();
        for (Book book : dataset) {
            authors.add(book.getAuthor());
        }
        System.out.println("\n--- All Unique Authors ---");
        for (String author : authors) {
            System.out.println(author);
        }
        System.out.println("------------------------");
    }

    // Task 3) Function to find all books by a given author
    public static void findBooksByAuthor(String authorName) {
        System.out.println("\n--- Books by " + authorName + " ---");
        boolean found = false;
        for (Book book : dataset) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println(" - " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for this author.");
        }
        System.out.println("------------------------");
    }

    


}