package seminars.fourth.book;

import java.util.List;

public interface BookRepository {
    Book findByAuthor(String author);
    List<Book> findAll();
}
