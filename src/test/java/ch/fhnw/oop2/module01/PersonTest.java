package ch.fhnw.oop2.module01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testInit() {
        //given
        Person urs = new Person(76, 145, 1.66);

        //when

        //then
        Assertions.assertEquals(76, urs.getAge());
        Assertions.assertEquals(145, urs.getWeight());
        Assertions.assertEquals(1.66, urs.getHeight());
    }

    @Test
    void testBMI() {
        //given
        Person heidi = new Person(38,60,1.65);
        // when
        double result = heidi.getBMI();

        //then
        Assertions.assertEquals(22, result, 0.1);
    }

    @Test
    void testInitializeFriends() {
        //given
        Person stuart = new Person(2354,35.0,0.80);
        //when
        int numberOfFriends = stuart.getNumberOfFriends();
        //then
        Assertions.assertEquals(0,numberOfFriends);
    }

    @Test
    void testNewFriends() {
        //given
        Person stuart = new Person(2354,35.0,0.80);
        Person kevin = new Person(2304,90.0,0.86);
        //when
        kevin.addFriend(stuart);
        //then
        Assertions.assertEquals(1, kevin.getNumberOfFriends());
        Assertions.assertEquals(1, stuart.getNumberOfFriends());
        Assertions.assertTrue(kevin.hasAsFriend(stuart));
        Assertions.assertTrue(stuart.hasAsFriend(kevin));

    }

}
