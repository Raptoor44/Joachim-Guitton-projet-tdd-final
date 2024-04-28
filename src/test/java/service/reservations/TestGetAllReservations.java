package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetAllReservations extends ReservationServiceTestAbstract{


    private List<Reservation> reservationsInTest = new LinkedList<Reservation>();

    @BeforeEach
    public void setUp(){
        super.setUp();

        initReservations();
        this.member.reservations = reservationsInTest;
    }

    @Test
    public void testGetAllReservations(){
        assertEquals(this.reservationsInTest, this.member.getHistoryOfReservations());
    }

    public void initReservations(){
        this.reservationsInTest.add(new Reservation());
    }
}
