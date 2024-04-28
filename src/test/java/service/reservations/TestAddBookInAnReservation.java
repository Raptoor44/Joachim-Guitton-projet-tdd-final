package service.reservations;

import org.example.models.Book;
import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddBookInAnReservation extends ReservationServiceTestAbstract{

    private Book bookToTest;

    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        super.setUp();

        this.bookToTest = new Book();
        this.bookToTest.setIsbn("2344049029");
        this.bookToTest.setEditeur("Toei");
        this.bookToTest.setTitle("one piece volume 100");
        this.bookToTest.setFormatBook(org.example.utils.FormatBook.Grand_Format);
        this.bookToTest.setAuthor("ODA");

        this.reservation = new Reservation();
    }

    @Test
    public void testAddBookInAnReservation() {
        boolean isValid = this.reservation.addBook(this.bookToTest);

        assertEquals(true, isValid);
    }

}
