package repository;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class BookDeleteTest extends BookRepositoryTestAbstract{


    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testBookDelete() {
        // Suppression du livre
        super.bookRepository.delete(super.bookToTest);

        // Vérification que la méthode delete a été appelée une fois avec le bon argument
        verify(super.bookRepository, times(1)).delete(super.bookToTest);
    }
}
