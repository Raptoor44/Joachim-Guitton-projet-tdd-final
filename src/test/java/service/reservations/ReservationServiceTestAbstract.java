package service.reservations;

import org.example.models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.Date;

public abstract class ReservationServiceTestAbstract {

    @Mock
    protected Member member;

    @BeforeEach
    public void setUp(){
        this.member = new Member();

        this.member.setCodeMember(1);
        this.member.setLastName("Guitton");
        this.member.setFirstName("Joachim");
        this.member.setBirthDay(new Date(2000, 26, 12));
        this.member.setSexe("Homme");
    }


}
