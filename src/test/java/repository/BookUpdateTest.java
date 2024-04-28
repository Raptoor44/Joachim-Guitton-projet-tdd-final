package repository;

import org.example.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookUpdateTest extends BookRepositoryTestAbstract {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testBookUpdate() {
        when(super.bookRepository.findByIsbn(any(String.class))).thenReturn(super.bookToTest);

        Book bookToUpdate = super.bookRepository.findByIsbn(super.bookToTest.getIsbn());

        bookToUpdate.setTitle("OP");

        super.bookRepository.save(bookToUpdate);

        assertNotNull(bookToUpdate);
        assertEquals("OP", bookToUpdate.getTitle());
    }
}
