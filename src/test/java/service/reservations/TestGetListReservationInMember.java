package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGetListReservationInMember extends ReservationServiceTestAbstract{

    @BeforeEach
    public void setUp() {
        super.setUp();
        insertMultipleReservations();
        finishMultipleReservations();
    }

    @Test
    public void testGetListReservationInMember() {
        assertTrue(this.member.getValidReservations() instanceof List);
    }

    public void insertMultipleReservations(){
        for(int i = 0; i<3; i++){
            Reservation r = new Reservation();
            r.setId(i);
            this.member.addReservation(r);
        }
    }

    public void finishMultipleReservations(){
        for(int i = 0; i<2; i++){
            this.member.finishReservation(this.member.reservations.get(i));
        }
    }
}
