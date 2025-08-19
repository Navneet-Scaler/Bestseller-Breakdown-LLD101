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
}