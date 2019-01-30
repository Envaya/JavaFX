package ch.fhnw.oop2.module11.selectionhandling.views;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import ch.fhnw.oop2.module11.selectionhandling.presentationmodels.CountryPM;
import ch.fhnw.oop2.module11.selectionhandling.presentationmodels.EuropePM;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Dieter Holz
 */
public class CountryForm extends GridPane implements ViewMixin {

	private final EuropePM rootPM;

	private Label     idLabel;
	private Label     idField;
	private Label     nameLabel;
	private TextField nameField;
	private Label     areaLabel;
	private TextField areaField;

	public CountryForm(EuropePM rootPM) {
		this.rootPM = rootPM;
		init();
	}

    @Override
    public void initializeSelf() {
        getStyleClass().add("form");
    }

    @Override
	public void initializeControls() {
		idLabel = new Label("Id");
		idField = new Label();

		nameLabel = new Label("Name");
		nameField = new TextField();

		areaLabel = new Label("Fl\u00e4che in km\u00B2");  //unicode character verwenden
		areaField = new TextField();
	}

	@Override
	public void layoutControls() {
		ColumnConstraints grow = new ColumnConstraints();
		grow.setHgrow(Priority.ALWAYS);
        ColumnConstraints fixed = new ColumnConstraints();
        getColumnConstraints().addAll(fixed, grow);

		addRow(0, idLabel  , idField);
		addRow(1, nameLabel, nameField);
		addRow(2, areaLabel, areaField);
	}

    @Override
    public void setupValueChangedListeners() {
        rootPM.selectedIdProperty().addListener((observable, oldValue, newValue) -> {
            CountryPM oldCountry = rootPM.getCountry(oldValue.intValue());
            CountryPM newCountry = rootPM.getCountry(newValue.intValue());

            if(oldCountry != null){
                idField.textProperty().unbind();
                nameField.textProperty().unbindBidirectional(oldCountry.nameProperty());
                areaField.textProperty().unbindBidirectional(oldCountry.areaProperty());
            }

            if(newCountry != null){
                idField.textProperty().bind(newCountry.idProperty().asString());
                nameField.textProperty().bindBidirectional(newCountry.nameProperty());
                areaField.textProperty().bindBidirectional(newCountry.areaProperty(), new NumberStringConverter());
            }

        });
    }
}
