package ch.fhnw.oop2.module11.stableselection.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import ch.fhnw.oop2.module11.stableselection.presentationmodels.EuropePM;

/**
 * @author Dieter Holz
 */
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
		nameLabel.textProperty().bind(europe.getCountryProxy().nameProperty());
		areaLabel.textProperty().bind(europe.getCountryProxy().areaProperty().asString());
	}

}
