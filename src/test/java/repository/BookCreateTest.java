package repository;

import org.example.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookCreateTest extends BookRepositoryTestAbstract{



    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testCreateBook(){

        // Définir le comportement du mock pour la méthode save()
        when(bookRepository.save(any(Book.class))).thenReturn(this.bookToTest);

        // Appel de la méthode à tester
        Book savedBook = bookRepository.save(this.bookToTest);

        // Vérification que la méthode save() a été appelée une fois avec le bon argument de livre
        verify(bookRepository, times(1)).save(eq(this.bookToTest));

        // Vérification que la méthode save() renvoie le livre sauvegardé
        assertEquals(this.bookToTest, savedBook);
    }
}
