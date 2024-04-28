package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFinishAnReservation extends ReservationServiceTestAbstract{

    private Reservation reservation;
    private Date dateTimeToday;
    @BeforeEach
    public void setUp() {
        this.dateTimeToday = new Date();

        this.reservation = new Reservation();
        this.member.addReservation(this.reservation);
    }

    @Test
    public void TestFinishAnReservation(){
        this.member.finishReservation(this.reservation)
        //Avec la date du jour, la vérification doit envoyer false car nous avons mise fin à la validité de la réservation.
        assertEquals(null, this.member.getReservation());
    }
}
