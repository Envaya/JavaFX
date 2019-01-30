package ch.fhnw.oop2.module11.stableselection.views;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import ch.fhnw.oop2.module11.stableselection.presentationmodels.EuropePM;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Dieter Holz
 */
public class CountryForm extends GridPane implements ViewMixin {

	private final EuropePM europe;

	private Label     idLabel;
	private Label     idField;
	private Label     nameLabel;
	private TextField nameField;
	private Label     areaLabel;
	private TextField areaField;

	public CountryForm(EuropePM europe) {
		this.europe = europe;
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

		areaLabel = new Label("Fl\u00e4che in km\u00B2"); //unicode character verwenden
		areaField = new TextField();
	}

	@Override
	public void layoutControls() {
		ColumnConstraints grow = new ColumnConstraints();
		grow.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(new ColumnConstraints(), grow);

		addRow(0, idLabel  , idField);
		addRow(1, nameLabel, nameField);
		addRow(2, areaLabel, areaField);
	}

	@Override
	public void setupBindings() {
		idField.textProperty().bind(europe.getCountryProxy().idProperty().asString());

		nameField.textProperty().bindBidirectional(europe.getCountryProxy().nameProperty());

		areaField.textProperty().bindBidirectional(europe.getCountryProxy().areaProperty(), new NumberStringConverter());
	}


}
