package service.reservations;

import org.apache.tomcat.jni.Library;
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

        Member memberB = new Member();
        memberB.setCodeMember(1);
        memberB.setFirstName("Mister B");
        memberB.setLastName("example last name");
        memberB.setBirthDay(new Date());
        memberB.setSexe("femme");
        this.library = new Library();

        this.library.addMember(memberA);
        this.library.addMember(memberB);

    }

    @Test
    public void testSendMailMultipleMembersWithReservationDateNotValid() {
        // Redirige la sortie de la console vers un flux de sortie mémoire
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Nous ajout 5 mois à la date d'aujourd'hui
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 5);

        Date dateTimeToday = calendar.getTime();

        this.reservation = new Reservation(dateTimeToday);

        this.library.sendMailDateNotValid();

        // Capture de la sortie de la console dans le flux de sortie mémoire
        String consoleOutput = outContent.toString().trim();
        assertEquals("mail envoyé à Mister A. mail envoyé à Mister B.", consoleOutput);
    }
}
