package service;

import org.example.exceptions.InvalidIsbnLenghtException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestInvalidLenghtIsbn extends BookServiceTestAbstract{

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void TestInvalidIsbnLenght() {

        //On redéfinit l'isbn de la classe mère :
        this.bookToTest.setIsbn("234404029");

        assertThrows(InvalidIsbnLenghtException.class, () -> this.bookService.save(this.bookToTest));
    }
}
