package service.reservations;

import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMailReminderOfReservationsIsNotValid extends ReservationServiceTestAbstract{

    @BeforeEach
    public void setUp() {
        super.setUp();
        insertMultipleReservations();
        finishMultipleReservations();
    }

    @Test
    public void TestMailReminderOfReservationsIsNotValid() {

        // Redirige la sortie de la console vers un flux de sortie mémoire
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        this.member.sendMailsReminderOfReservationsIsNotValid();

        // Capture de la sortie de la console dans le flux de sortie mémoire
        String consoleOutput = outContent.toString().trim();

        // Utilisation des assertions pour vérifier que la sortie de la console correspond à ce qui est attendu
        assertEquals("Envoie du mail, la réservation ayant pour id : 0 ayant pour date de signature Sun Apr 28 20:28:04 CEST 2024 et ayant pour date de fin de validité Wed Aug 28 20:28:04 CEST 2024 n'est plus valide\n" +
                "Envoie du mail, la réservation ayant pour id : 1 ayant pour date de signature Sun Apr 28 20:28:04 CEST 2024 et ayant pour date de fin de validité Wed Aug 28 20:28:04 CEST 2024 n'est plus valide", consoleOutput);
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
