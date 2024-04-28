package service.reservations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
        when(this.member.addReservation(any(Reservation.class)).thenReturn(this.reservation));

        assertEquals(this.reservation, this.member.addReservation(this.reservation));
    }
}
