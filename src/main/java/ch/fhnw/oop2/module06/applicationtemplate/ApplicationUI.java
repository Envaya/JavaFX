package ch.fhnw.oop2.module06.applicationtemplate;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class ApplicationUI extends StackPane {
    private Button button;

    public ApplicationUI(){
        initializeSelf();
        initializeControls();
        layoutControls();
    };

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        button = new Button("Hello World");
    }
    private void layoutControls() {
        getChildren().add(button);
    }
}
