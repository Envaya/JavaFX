package ch.fhnw.oop2.module08.colormixer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.scene.paint.Color;

public class ColorMixerPM {

    private StringProperty title = new SimpleStringProperty();
    // Farbwert für Rot:
    private IntegerProperty red = new SimpleIntegerProperty();
    private IntegerProperty green = new SimpleIntegerProperty();
    private IntegerProperty blue = new SimpleIntegerProperty();

    private ObjectProperty<Color> mixedColor = new SimpleObjectProperty<>();

    public ColorMixerPM() {

        ChangeListener<Number> listener = (observable, oldValue, newValue) -> {
            setMixedColor(Color.rgb(getRed(), getGreen(), getBlue()));
        };
        red.addListener(listener);
        blue.addListener(listener);
        blue.addListener(listener);

//        Gleiche Lösung als binding
//        mixedColor.bind(Bindings.createObjectBinding(() -> Color.rgb(getRed(), getGreen(), getBlue()), red, green, blue));

//        red.addListener((observable, oldValue, newValue) -> {
//            setMixedColor(Color.rgb(getRed(), getGreen(), getBlue()));
//        });
//        blue.addListener((observable, oldValue, newValue) -> {
//            setMixedColor(Color.rgb(getRed(), getGreen(), getBlue()));
//        });
//        blue.addListener((observable, oldValue, newValue) -> {
//            setMixedColor(Color.rgb(getRed(), getGreen(), getBlue()));
//        });
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getRed() {
        return red.get();
    }

    public IntegerProperty redProperty() {
        return red;
    }

    public void setRed(int red) {
        this.red.set(red);
    }

    public int getGreen() {
        return green.get();
    }

    public IntegerProperty greenProperty() {
        return green;
    }

    public void setGreen(int green) {
        this.green.set(green);
    }

    public int getBlue() {
        return blue.get();
    }

    public IntegerProperty blueProperty() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue.set(blue);
    }

    public Color getMixedColor() {
        return mixedColor.get();
    }

    public ObjectProperty<Color> mixedColorProperty() {
        return mixedColor;
    }

    public void setMixedColor(Color mixedColor) {
        this.mixedColor.set(mixedColor);
    }
}
