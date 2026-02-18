import java.time.LocalDate;

public class Book{

    public String name;
    public String authorName;
    public double price;
    public String publisherName;
    public String genre;
    public String ISBN;
    public LocalDate dateOfPublishing;

    public Book()
    {
        name = "unknown";
        price = 0.0;
        authorName = "unknown";
        publisherName = "unknown publisher";
        genre = "uncategorized";
        ISBN = "0000000";
        dateOfPublishing = LocalDate.parse("2020-01-01");

    }

    public Book(String n, String a, double p, String isbn) throws InvalidPriceException 
    {
        
        name = n;
        authorName = a;
        if (p<0){
            throw new InvalidPriceException("price cannot be negative.");
        }
        price = p;
        ISBN = isbn;
    }

    public Book(String n, String a, String g, double p) throws InvalidPriceException , InvalidGenreException
    {

        name =n;
        authorName=a;
        if(!g.equalsIgnoreCase("fiction") && !g.equalsIgnoreCase("autobiography"))
            throw new InvalidGenreException("invalid genre.");
        genre = g;
        if (p<0){
            throw new InvalidPriceException("price cannot be negative.");
        }
        price =p;
    }

    public Book(Book b){
        price=b.price;
        publisherName=b.publisherName;
        authorName=b.authorName;
        name = b.name;
        genre = b.genre;
        ISBN = b.ISBN;
        dateOfPublishing = b.dateOfPublishing;
    }
}
