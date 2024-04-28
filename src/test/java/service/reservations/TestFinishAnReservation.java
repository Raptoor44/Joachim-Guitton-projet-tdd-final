package service.reservations;

import org.example.exceptions.NotFoundReservationException;
import org.example.exceptions.Over3ReservationsInMemberException;
import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFinishAnReservation extends ReservationServiceTestAbstract{

    private Reservation reservation;
    @BeforeEach
    public void setUp() {
        super.setUp();
        this.reservation = new Reservation();
        this.member.addReservation(this.reservation);
    }

    @Test
    public void TestFinishAnReservation(){
        this.member.finishReservation(this.reservation);
        //Avec la date du jour, la vérification doit envoyer false car nous avons mise fin à la validité de la réservation.
        assertThrows(NotFoundReservationException.class, () -> this.member.getReservation(reservation));
    }
}
