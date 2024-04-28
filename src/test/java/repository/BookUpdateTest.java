package repository;

import org.example.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookUpdateTest  extends BookCreateTest{

    @BeforeEach
    public void setUp(){
        super.setUp();
    }
    @Test
    public void testBookUpdate(){

        Book bookToUpdate = super.bookRepository.findByIsbn(super.bookToTest.getIsbn());

        bookToUpdate.setTitre("OP");

        super.bookRepository.save(bookToUpdate);

        assertNotNull(bookToUpdate);
        assertEquals("OP", bookToUpdate.getTitre());
    }

}
