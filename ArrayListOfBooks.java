import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayListOfBooks {

    public static void main(String[] args) {
        ArrayList<Book> bList = new ArrayList<>();

        bList.add(new Book());

        try {
            Book b2 = new Book("Eclipse", "Stephenie Mayor", "horror", 455.99);
            bList.add(b2);
            
            Book b4 = b2;
            b4.name = "Harry Potter and the Deathly Hallows";
            b4.authorName = "J.K.Rowling";
            bList.add(b4);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        try {
            Book b3 = new Book("Atomic Habits", "James Clear", 899.99, "HLP12345");
            bList.add(b3);

            Book b5 = new Book(b3);
            b5.authorName = "J.R.R Tolkin";
            b5.name = "Lord of the Rings";
            bList.add(b5);
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--- Book Details ---");
        bList.forEach(b -> {
            System.out.println("Title: " + b.name);
            System.out.println("Author: " + b.authorName);
            System.out.println("Price: " + b.price);
            System.out.println("ISBN: " + b.ISBN);
            System.out.println("Genre: " + b.genre);
            System.out.println("Publisher: " + b.publisherName);
            System.out.println("Date: " + b.dateOfPublishing);
            System.out.println("--------------------");
        });

        double averagePrice = bList.stream()
                .mapToDouble(b -> b.price)
                .average()
                .orElse(0.0);

        System.out.println("Average Price of Books: " + averagePrice);

        System.out.println("\n--- Books Grouped by Genre ---");
        Map<String, java.util.List<Book>> booksByGenre = bList.stream()
                .collect(Collectors.groupingBy(b -> b.genre == null ? "Unknown" : b.genre));

        booksByGenre.forEach((genre, books) -> {
            System.out.println("Genre: " + genre);
            books.forEach(b -> System.out.println(" - " + b.name));
        });
    }
}