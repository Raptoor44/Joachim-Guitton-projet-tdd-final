package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetListReservationInMember extends ReservationServiceTestAbstract{

    private Reservation reservation;

    public List<Reservation> reservationsInTest = new LinkedList<Reservation>();

    @BeforeEach
    public void setUp() {
        super.setUp();
        insertMultipleReservations();
        finishMultipleReservations();
    }

    @Test
    public void testGetListReservationInMember() {
        assertEquals(this.member.getValidReservations(), this.reservationsInTest);
    }

    public void insertMultipleReservations(){
        for(int i = 0; i<25; i++){
            Reservation r = new Reservation();
            this.member.addReservation(r);
            this.reservationsInTest.add(r);
        }
    }

    public void finishMultipleReservations(){
        for(int i = 0; i<10; i++){
            this.member.finishReservation(this.member.reservations.get(i));
            reservationsInTest.remove(reservationsInTest.get(i));
        }
    }
}
