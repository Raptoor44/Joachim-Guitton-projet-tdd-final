package repository;

import org.example.models.Book;
import org.example.repository.BookRepostiory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookCreateTest {

    @Mock
    protected BookRepostiory bookRepository;

    protected Book bookToTest;

    @BeforeEach
    public void setUp(){
        this.bookRepository = Mockito.mock(BookRepostiory.class);

        this.bookToTest = new Book();

        this.bookToTest.setIsbn("2344049029");
        this.bookToTest.setTitle("one piece volume 100");
        this.bookToTest.setAuthor("Oda");
        this.bookToTest.setEditeur("Toei");
        this.bookToTest.setFormatBook(org.example.utils.FormatBook.Grand_Format);
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
