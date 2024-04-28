package service;

import org.example.exceptions.AttributesMissingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAttributesMissingInBookRepo extends BookServiceTestAbstract{

    @BeforeEach
    public void setUp() {
        super.setUp();
        this.bookToTest.setAuthor(null);
        //L'auteur n'est pas présent, AttributesMissingException doit être levé.
    }

    @Test
    public void insertTestBook() {

        assertThrows(AttributesMissingException.class, () -> this.bookService.save(this.bookToTest));
    }
}
