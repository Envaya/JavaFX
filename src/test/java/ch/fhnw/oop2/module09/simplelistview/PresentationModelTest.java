package ch.fhnw.oop2.module09.simplelistview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresentationModelTest {

    @Test
    void testAdd() {
        //given
        PresentationModel pm = new PresentationModel();

        //then
        Assertions.assertEquals(0, pm.getAllElements().size());

        //when
        pm.addNewElement();

        //then
        Assertions.assertEquals(1, pm.getAllElements().size());
    }

}