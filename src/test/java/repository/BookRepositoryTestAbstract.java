package repository;

import org.example.models.Book;
import org.example.repository.BookRepostiory;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

public abstract class BookRepositoryTestAbstract {

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

}
