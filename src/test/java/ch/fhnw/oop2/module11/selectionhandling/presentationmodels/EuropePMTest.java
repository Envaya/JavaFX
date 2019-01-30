package ch.fhnw.oop2.module11.selectionhandling.presentationmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Dieter Holz
 */
public class EuropePMTest {

    @Test
    public void testGetCountry(){
        // given
        EuropePM pm = new EuropePM();

        //when
        CountryPM c = pm.getCountry(3);

        //then
        assertEquals("Italien", c.getName());

        //when
        c = pm.getCountry(99);

        assertNull(c);
    }

}