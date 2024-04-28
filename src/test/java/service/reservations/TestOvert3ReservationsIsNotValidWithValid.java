package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestOvert3ReservationsIsNotValidWithValid extends ReservationServiceTestAbstract{
    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testOvert3ReservationsIsNotValidWithValid(){
        this.insert3ReservationIsValid();
        assertDoesNotThrow(() -> this.insertReservationIsNotValid());
    }

    public void insertReservationIsNotValid(){
        for(int i = 0; i<20; i++){
            Reservation r = new Reservation();
            r.setReservationIsValid(false);
            this.member.addReservation(r);
        }
    }

    public void insert3ReservationIsValid(){
        for(int i = 0; i<3; i++){
            Reservation r = new Reservation();
            this.member.addReservation(r);
        }
    }
}
