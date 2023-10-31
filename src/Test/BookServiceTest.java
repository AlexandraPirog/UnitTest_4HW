package Test;

import org.junit.Before;
import org.junit.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.Arrays;
import java.util.List;

import static javax.management.Query.times;
import static jdk.internal.jimage.ImageLocation.verify;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookRepository mockBookRepository;
    private BookService mockBookService;

    @Before
    public void setUp() {
        // создаем заглушку и объект через заглушку
        mockBookRepository = mock(BookRepository.class);
        mockBookService = new BookService(mockBookRepository);
    }

    @Test
    public void testFindBookByAuthor() {

        String author;
        String id;
        Book book = new Book(id, "Book", "Author");
        // Задаем поведение заглушки при вызове метода
        when(mockBookRepository.findByAuthor(author)).thenReturn(book);
        //получаем результат
        Book result = mockBookService.findBookById(author);
        Assert.assertEquals(book, result);
        verify(mockBookRepository, times(1)).findByAuthor(author);
    }

}


