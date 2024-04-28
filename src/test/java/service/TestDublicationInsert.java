package service;

import org.example.exceptions.DublicationInsertException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class TestDublicationInsert extends BookServiceTestAbstract{

    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testInsertDublication(){
        this.bookService.save(bookToTest);

        when(this.bookService.getBookRepostiory().findByIsbn(bookToTest.getIsbn())).thenReturn(bookToTest);

        assertThrows(DublicationInsertException.class, () -> this.bookService.save(this.bookToTest));
    }
}
