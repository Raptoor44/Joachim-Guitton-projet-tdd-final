package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreateReservation extends ReservationServiceTestAbstract{

    @Mock
    private Reservation reservation;

    @BeforeEach
    public void setUp(){
        super.setUp();

        this.reservation = Mockito.mock(Reservation.class);
    }

    @Test
    public void testCreateReservation(){

        assertEquals(true, this.member.addReservation(this.reservation));
    }
}
