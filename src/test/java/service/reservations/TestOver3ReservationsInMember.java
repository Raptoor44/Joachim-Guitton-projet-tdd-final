package service.reservations;

import org.example.exceptions.Over3ReservationsInMemberException;
import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestOver3ReservationsInMember extends ReservationServiceTestAbstract {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testOver3ReservationsInMember() {
        assertThrows(Over3ReservationsInMemberException.class, () -> this.insert3ReservationsInMember());
    }

    public void insert3ReservationsInMember(){
        for(int i = 0; i<4; i++){
            Reservation r = new Reservation();
            this.member.addReservation(r);
        }
    }
}
