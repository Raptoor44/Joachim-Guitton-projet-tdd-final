package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDublicationInsert extends BookServiceTestAbstract{

    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testInsertDublication(){
        this.bookService.save(bookToTest);

        assertThrows(DublicationInsertException.class, () => this.bookService.save(this.bookToTest));
    }
}
