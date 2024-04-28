package service.reservations;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

public abstract class ReservationServiceTestAbstract {

    @Mock
    protected Member member;

    @BeforeEach
    public void setUp(){
        this.member = new Member();

        this.member.setCodeMember(1);
        this.member.setLastName("Guitton");
        this.member.setFirstName("Joachim");
        this.member.setBirthDay("26-12-2000");
        this.member.setSexe("Homme");
    }


}
