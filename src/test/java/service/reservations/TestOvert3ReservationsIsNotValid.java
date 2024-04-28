package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestOvert3ReservationsIsNotValid extends ReservationServiceTestAbstract{

    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testOvert3ReservationsIsNotValid(){
        assertDoesNotThrow(() -> this.insertReservationIsNotValid());
    }

    public void insertReservationIsNotValid(){
        for(int i = 0; i<20; i++){
            Reservation r = new Reservation();
            r.setReservationIsValid(false);
            this.member.addReservation(r);
        }
    }
}
