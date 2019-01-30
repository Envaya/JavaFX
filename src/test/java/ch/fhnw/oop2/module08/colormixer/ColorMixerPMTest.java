package ch.fhnw.oop2.module08.colormixer;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorMixerPMTest {
    @Test
    void textMixerColor() {
        //given
        ColorMixerPM mixer = new ColorMixerPM();

        //when
        mixer.setRed(255);
        mixer.setGreen(0);
        mixer.setBlue(0);

        //then
        assertEquals(Color.rgb(255, 0, 0), mixer.getMixedColor());
    }
}