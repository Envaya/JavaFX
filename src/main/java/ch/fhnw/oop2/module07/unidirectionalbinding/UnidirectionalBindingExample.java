package ch.fhnw.oop2.module07.unidirectionalbinding;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class UnidirectionalBindingExample extends VBox {
    private Label  label;
    private Slider slider;

    public UnidirectionalBindingExample() {
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf(){
        String stylesheet = getClass().getResource("style.css").toExternalForm();
 		getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        label  = new Label();
        slider = new Slider(0, 100, 50);
    }

    private void layoutControls() {
        setPadding(new Insets(10));
        setSpacing(10);

        getChildren().addAll(label, slider);
    }

    private void setupValueChangedListeners() {
    }

    private void setupEventHandlers() {
    }

    private void setupBindings() {
        label.textProperty().bind(slider.valueProperty().asString());

    }

}
