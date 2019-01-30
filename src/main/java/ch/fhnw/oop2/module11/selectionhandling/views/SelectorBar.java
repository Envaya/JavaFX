package ch.fhnw.oop2.module11.selectionhandling.views;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import ch.fhnw.oop2.module11.selectionhandling.presentationmodels.EuropePM;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Dieter Holz
 */
public class SelectorBar extends HBox implements ViewMixin {

	private final EuropePM rootPM;

	private Slider    slider;
	private TextField inputField;

	public SelectorBar(EuropePM rootPM) {
		this.rootPM = rootPM;
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
		slider.setMax(rootPM.getAllCountries().size() - 1);

		inputField = new TextField();
	}

	@Override
	public void layoutControls() {
		getChildren().addAll(slider, inputField);
	}

	@Override
	public void setupBindings() {
		slider.valueProperty().bindBidirectional(rootPM.selectedIdProperty());
		inputField.textProperty().bindBidirectional(rootPM.selectedIdProperty(), new NumberStringConverter());
	}
}
