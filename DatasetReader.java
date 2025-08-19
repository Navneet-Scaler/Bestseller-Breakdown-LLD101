import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetReader {

    public static List<Book> readDataset(String filePath) {
        List<Book> books = new ArrayList<>();
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line of the CSV
            br.readLine();

            while ((line = br.readLine()) != null) {
                // This regex handles book titles that might contain commas inside quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (data.length == 7) {
                    try {
                        String title = data[0];
                        String author = data[1];
                        double userRating = Double.parseDouble(data[2]);
                        int reviews = Integer.parseInt(data[3]);
                        int price = Integer.parseInt(data[4]);
                        int year = Integer.parseInt(data[5]);
                        String genre = data[6];

                        Book book = new Book(title, author, userRating, reviews, price, year, genre);
                        books.add(book);
                    } catch (NumberFormatException e) {
                        System.out.println("Could not parse line, skipping: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}