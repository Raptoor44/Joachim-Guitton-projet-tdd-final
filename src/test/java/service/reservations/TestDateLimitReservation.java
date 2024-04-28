package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDateLimitReservation extends ReservationServiceTestAbstract {

    private Date dateTimeToday;

    private Reservation reservation;

    @BeforeEach
    public void setUp() {

        //Nous ajout 5 mois à la date d'aujourd'hui
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 5);

        this.dateTimeToday = calendar.getTime();

        this.reservation = new Reservation();
    }

    @Test
    public void testDateLimitReservation() {
        assertEquals(false, reservation.isValid(dateTimeToday));
    }
}
