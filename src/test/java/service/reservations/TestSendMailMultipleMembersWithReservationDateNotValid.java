package service.reservations;

import org.example.Library;
import org.example.models.Member;
import org.example.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSendMailMultipleMembersWithReservationDateNotValid extends ReservationServiceTestAbstract{

    private Library library;

    @BeforeEach
    public void setUp() {
        super.setUp();

        Member memberA = new Member();
        memberA.setCodeMember(1);
        memberA.setFirstName("Mister A");
        memberA.setLastName("example last name");
        memberA.setBirthDay(new Date());
        memberA.setSexe("homme");

        Reservation reservationA = new Reservation();
        reservationA.setId(1);
        memberA.reservations.add(reservationA);

        Reservation reservationB = new Reservation();
        reservationB.setId(2);
        memberA.reservations.add(reservationB);

        Reservation reservationC = new Reservation();
        reservationC.setId(3);
        memberA.reservations.add(reservationC);


        Member memberB = new Member();
        memberB.setCodeMember(1);
        memberB.setFirstName("Mister B");
        memberB.setLastName("example last name");
        memberB.setBirthDay(new Date());
        memberB.setSexe("femme");

        Reservation reservationD = new Reservation();
        reservationD.setId(4);
        memberB.reservations.add(reservationD);

        Reservation reservationE = new Reservation();
        reservationE.setId(5);
        memberB.reservations.add(reservationE);

        this.library = new Library();

        this.library.addMember(memberA);
        this.library.addMember(memberB);

    }

    @Test
    public void testSendMailMultipleMembersWithReservationDateNotValid() {
        // Redirige la sortie de la console vers un flux de sortie mémoire
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Nous ajoutons 5 mois en plus pour effectuer la vérification de la date limite d'une réservation.
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 5);

        Date dateTimeToday = calendar.getTime();

        this.library.sendMailDateNotValid(dateTimeToday);

        // Capture de la sortie de la console dans le flux de sortie mémoire
        String consoleOutput = outContent.toString().trim(); //Il est possible que assertEquals ne fonctionne, essayé en debug pour simulé l'envoie de mail.
        assertEquals("La réservation : 1 est invalide\n" +
                "La réservation : 2 est invalide\n" +
                "La réservation : 3 est invalide\n" +
                "La réservation : 4 est invalide\n" +
                "La réservation : 5 est invalide", consoleOutput);
    }
}
