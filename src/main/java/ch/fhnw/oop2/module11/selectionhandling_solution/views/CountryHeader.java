package ch.fhnw.oop2.module11.selectionhandling_solution.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import ch.fhnw.oop2.module11.selectionhandling_solution.presentationmodels.CountryPM;
import ch.fhnw.oop2.module11.selectionhandling_solution.presentationmodels.EuropePM;

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
	public void setupValueChangedListeners() {
		europe.selectedCountryIdProperty().addListener((observable, oldValue, newValue) -> {
			CountryPM oldSelection = europe.getCountry(oldValue.intValue());
			CountryPM newSelection = europe.getCountry(newValue.intValue());

			if (oldSelection != null) {
				nameLabel.textProperty().unbind();
				areaLabel.textProperty().unbind();
			}

			if (newSelection != null) {
				nameLabel.textProperty().bind(newSelection.nameProperty());
				areaLabel.textProperty().bind(newSelection.areaProperty().asString("%.2f km\u00B2"));
			}
		});
	}
}
