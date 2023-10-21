package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    InMemoryBookRepository inBookRepo;
    Book someBook;

    @BeforeEach
    void setUp () {
        inBookRepo = new InMemoryBookRepository();
        someBook = new Book("666", "Test Book", "Tester");
    }

    @Test
    void testBookServiceFindById() {
        BookRepository bookRepo = mock(BookRepository.class);
        BookService bookServ = new BookService(bookRepo);

        when(bookRepo.findById("1")).thenReturn(someBook);
        Book book = bookServ.findBookById("1");
        verify(bookRepo, times(1)).findById("1");

        assertThat(book.getId()).isEqualTo("666");
        assertThat(book.getTitle()).isEqualTo("Test Book");
    }

    @Test
    void testBookServiceFindByIdVerTwo() {
        BookRepository bookRepo = mock(BookRepository.class);
        BookService bookServ = new BookService(bookRepo);

        when(bookRepo.findById("1")).thenReturn(inBookRepo.findById("1"));
        Book book = bookServ.findBookById("1");
        verify(bookRepo, times(1)).findById("1");

        assertThat(book.getId()).isEqualTo("1");
        assertThat(book.getTitle()).isEqualTo("Book1");
    }

    @Test
    void testBookServiceFindAllBooks() {
        BookRepository bookRepo = mock(BookRepository.class);
        BookService bookServ = new BookService(bookRepo);

        when(bookRepo.findAll()).thenReturn(inBookRepo.findAll());
        List<Book> books = bookServ.findAllBooks();
        verify(bookRepo, times(1)).findAll();

        assertThat(books).isNotEmpty().hasSize(2).isEqualTo(inBookRepo.findAll());
    }


}