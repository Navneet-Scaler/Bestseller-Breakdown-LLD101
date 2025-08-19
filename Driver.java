import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Driver {

    private static List<Book> dataset;

    public static void main(String[] args) {
        dataset = DatasetReader.readDataset("bestsellers.csv");
        if (dataset.isEmpty()) {
            System.out.println("Dataset could not be loaded. Exiting.");
            return;
        }
        System.out.println("✅ Successfully loaded " + dataset.size() + " book records.");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n===== Amazon Bestsellers Menu =====");
            System.out.println("1. Get total books by an author");
            System.out.println("2. List all unique authors");
            System.out.println("3. List all books by an author");
            System.out.println("4. Find books by user rating");
            System.out.println("5. Get prices of books by an author");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter author's name: ");
                        String authorCountName = scanner.nextLine();
                        countBooksByAuthor(authorCountName);
                        break;
                    case 2:
                        printAllAuthors();
                        break;
                    case 3:
                        System.out.print("Enter author's name: ");
                        String authorBooksName = scanner.nextLine();
                        findBooksByAuthor(authorBooksName);
                        break;
                    case 4:
                        System.out.print("Enter user rating (e.g., 4.7): ");
                        double rating = Double.parseDouble(scanner.nextLine());
                        findBooksByRating(rating);
                        break;
                    case 5:
                        System.out.print("Enter author's name: ");
                        String authorPriceName = scanner.nextLine();
                        findPricesByAuthor(authorPriceName);
                        break;
                    case 6:
                        System.out.println("Exiting application. Goodbye! 👋");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        scanner.close();
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

    // Task 4) Function to find books by a specific rating
    public static void findBooksByRating(double rating) {
        System.out.println("\n--- Books with a rating of " + rating + " ---");
        boolean found = false;
        for (Book book : dataset) {
            if (book.getUserRating() == rating) {
                System.out.println(" - " + book.getTitle() + " by " + book.getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with this exact rating.");
        }
        System.out.println("---------------------------------");
    }

    // Task 5) Function to list book prices by an author
    public static void findPricesByAuthor(String authorName) {
        System.out.println("\n--- Book Prices by " + authorName + " ---");
        boolean found = false;
        for (Book book : dataset) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println(" - " + book.getTitle() + ": $" + book.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for this author.");
        }
        System.out.println("---------------------------------");
    }



}