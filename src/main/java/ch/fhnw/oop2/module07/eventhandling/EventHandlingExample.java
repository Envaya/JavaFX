package ch.fhnw.oop2.module07.eventhandling;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class EventHandlingExample extends StackPane {
    private static final String DEFAULT_TEXT = "Click Me!";

    private Button button;

    public EventHandlingExample() {
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        button = new Button(DEFAULT_TEXT);
    }

    private void layoutControls() {
        getChildren().add(button);
    }

    private void setupEventHandlers() {

        button.setOnMouseEntered(event -> button.setTextFill(Color.DEEPPINK));

        button.setOnMouseExited(event -> button.setTextFill(Color.BLACK));

        button.setOnMouseClicked(event -> {
            button.setText("FUCK");
            button.setTextFill(Color.HONEYDEW);
        }
        );

        button.setOnZoom(event -> {
            button.setScaleX(event.getTotalZoomFactor());
            button.setScaleY(event.getTotalZoomFactor());
        });

        button.setOnRotate(event -> {
            button.setRotate(event.getTotalAngle());
        });

        setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                button.setText(DEFAULT_TEXT);
            }
        });
    }


}
