package ch.fhnw.oop2.module13.undoredo.views;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

import ch.fhnw.oop2.module13.undoredo.presentationmodels.CountryPM;
import ch.fhnw.oop2.module13.undoredo.presentationmodels.EuropePM;

/**
 * @author Dieter Holz
 */
public class SelectorBar extends HBox implements ViewMixin {

	private final EuropePM europe;

	private Slider              slider;
	private TextField           inputField;
	private ComboBox<CountryPM> comboBox;

	public SelectorBar(EuropePM europe) {
		super();
		this.europe = europe;
		init();
	}

    @Override
    public void initializeSelf() {
        getStyleClass().add("selectorbar");
    }

    @Override
	public void initializeControls() {
		slider = new Slider();
		slider.setMin(0.0);
		slider.setMax(europe.allCountries().size() - 1);

		inputField = new TextField();

		comboBox = new ComboBox<>(europe.allCountries());
	}

	@Override
	public void layoutControls() {
		getChildren().addAll(slider, inputField, comboBox);
	}

	@Override
	public void setupBindings() {
		slider.valueProperty()   .bindBidirectional(europe.selectedCountryIdProperty());
		inputField.textProperty().bindBidirectional(europe.selectedCountryIdProperty(), new NumberStringConverter());
	}

	@Override
	public void setupValueChangedListeners() {
		comboBox.valueProperty().addListener((observable, oldValue, newValue) -> europe.setSelectedCountryId(newValue.getId()));

		europe.selectedCountryIdProperty().addListener((observable, oldValue, newValue) -> comboBox.getSelectionModel().select((int) newValue));
	}
}
