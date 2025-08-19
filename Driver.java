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
}