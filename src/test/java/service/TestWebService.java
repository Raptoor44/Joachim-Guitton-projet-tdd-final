package service;

import org.example.models.Book;
import org.example.repository.BookRepostiory;
import org.example.service.WebService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class TestWebService extends BookServiceTestAbstract {

    @Mock
    private BookRepostiory bookRepository;

    @Mock
    private WebService webService;

    private Book bookInWebService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        super.setUp();

        this.bookInWebService = new Book();
        this.bookInWebService.setIsbn("2344049029");
        this.bookInWebService.setTitle("one piece volume 100");
        this.bookInWebService.setFormatBook(org.example.utils.FormatBook.Grand_Format);
        this.bookInWebService.setAuthor("ODA");
        this.bookInWebService.setEditeur("Toei");
    }

    @Test
    public void testSaveBookByWebService() {
        // Configure behavior of webService mock
        when(webService.getBookByIsbn(any())).thenReturn(bookInWebService);

        // Configure behavior of bookRepository mock
        when(bookRepository.save(bookInWebService)).thenReturn(bookInWebService);

        //On définit le repository à l'intérieur de book service.
        when(this.bookService.getBookRepostiory().save(bookInWebService)).thenReturn(bookInWebService);

        // Set the mock objects
        this.webService.setBookRepostiory(bookRepository);
        this.bookService.setWebService(webService);

        this.bookToTest.setAuthor(null); // Nous supprimons l'auteur pour que le service de livre aille chercher l'information dans le web service.

        Book savedBook = this.bookService.save(bookToTest);

        assertNotNull(savedBook);
    }
}
