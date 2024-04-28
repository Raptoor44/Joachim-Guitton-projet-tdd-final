package service;

import org.example.exceptions.AttributesMissingException;
import org.example.models.Book;
import org.example.repository.BookRepostiory;
import org.example.service.BookService;
import org.example.service.WebService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAttributesMissingInBookRepo extends BookServiceTestAbstract{

    @BeforeEach
    public void setUp() {
        super.setUp();
        this.bookToTest.setAuteur(null);
        //L'auteur n'est pas présent, AttributesMissingException doit être levé.
    }

    @Test
    public void insertTestBook() {

        assertThrows(AttributesMissingException.class, () -> this.bookService.save(this.bookToTest));
    }
}
