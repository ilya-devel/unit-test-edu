package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    Book fullBook;

    @BeforeEach
    void setUp() {
        fullBook = new Book("999", "Test book", "Tester");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12s", "345", "b0s3"})
    void testCreateBookOnlyID(String id) {
        Book newBook = new Book(id);
        assertThat(newBook.getId()).isNotNull().isEqualTo(id);
    }

    @Test
    void testGetID() {
        assertThat(fullBook.getId()).isNotNull().isEqualTo("999");
    }

    @Test
    void testGetTitle() {
        assertThat(fullBook.getTitle()).isNotNull().isEqualTo("Test book");
    }

    @Test
    void testGetAuthor() {
        assertThat(fullBook.getAuthor()).isNotNull().isEqualTo("Tester");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ss123", "567"})
    void testSetID(String newId) {
        fullBook.setId(newId);
        assertThat(fullBook.getId()).isNotNull().isEqualTo(newId);
    }

    @ParameterizedTest
    @ValueSource(strings = {"New Title", "Some Title"})
    void testSetTitle(String newTitle) {
        fullBook.setTitle(newTitle);
        assertThat(fullBook.getTitle()).isNotNull().isEqualTo(newTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"New Tester", "Some Tester"})
    void testSetAuthor(String newAuthor) {
        fullBook.setAuthor(newAuthor);
        assertThat(fullBook.getAuthor()).isNotNull().isEqualTo(newAuthor);
    }

}
