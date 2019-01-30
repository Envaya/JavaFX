package ch.fhnw.oop2.module11.selectionhandling.views;

import ch.fhnw.oop2.module11.selectionhandling.presentationmodels.EuropePM;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;


public class CountryHeader extends VBox implements ViewMixin {

    private final EuropePM europe;

    private Label nameLabel;
    private Label areaLabel;

    public CountryHeader(EuropePM europe) {
        this.europe = europe;
        init();
    }

    @Override
    public void initializeSelf() {
        getStyleClass().add("header");
    }

    @Override
    public void initializeControls() {
        nameLabel = new Label();
        areaLabel = new Label();
    }
    @Override
    public void layoutControls() {
        getChildren().addAll(nameLabel, areaLabel);
    }

    @Override
    public void setupBindings() {
//        nameLabel.
//        inputField.textProperty().bindBidirectional(rootPM.selectedIdProperty(), new NumberStringConverter());
    }
}
