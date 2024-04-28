package service;

import org.example.exceptions.InvalidCharacterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestInvalidCharacters extends BookServiceTestAbstract {

    @BeforeEach
    public void setUp() {
        super.setUp();
        //Nous ajoutons le caractère en plus.
        this.bookToTest.setIsbn("2344e04029");
    }

    @Test
    public void TestInvalidIsbnLenght() {
        assertThrows(InvalidCharacterException.class, () -> this.bookService.save(this.bookToTest));
    }
}
