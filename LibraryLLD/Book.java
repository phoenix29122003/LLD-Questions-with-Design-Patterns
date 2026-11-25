package LibraryLLD;

import java.util.UUID;

public class Book {
    public String id;
    public String title;
    public String author;

    public Book(String title, String author){
        this.id=UUID.randomUUID().toString();
        this.title=title;
        this.author=author;
    }
}
