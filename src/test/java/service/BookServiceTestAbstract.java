package service;

import org.example.models.Book;
import org.example.repository.BookRepostiory;
import org.example.service.BookService;
import org.example.service.WebService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public abstract class BookServiceTestAbstract {

    @Mock
    protected BookRepostiory bookRepository;

    @Mock
    protected  BookRepostiory bookRepositoryWebService;

    protected BookService bookService;

    protected Book bookToTest;

    protected WebService webService;

    @BeforeEach
    public void setUp() {
        this.bookRepository = Mockito.mock(BookRepostiory.class);

        this.bookRepositoryWebService = Mockito.mock(BookRepostiory.class);
        this.webService = new WebService();

        // Définir le comportement du mock pour la méthode save()
        when(bookRepository.save(any(Book.class))).thenReturn(this.bookToTest);
        when(bookRepositoryWebService.save(any(Book.class))).thenReturn(this.bookToTest);

        this.webService.setBookRepostiory(this.bookRepositoryWebService);
        this.bookService = new BookService(this.bookRepository, this.webService);

        this.bookToTest = new Book();
        this.bookToTest.setIsbn("2344049029");
        this.bookToTest.setEditor("Toei");
        this.bookToTest.setTitle("one piece volume 100");
        this.bookToTest.setFormatBook(org.example.utils.FormatBook.Grand_Format);
        this.bookToTest.setAuthor("ODA");
    }
}
