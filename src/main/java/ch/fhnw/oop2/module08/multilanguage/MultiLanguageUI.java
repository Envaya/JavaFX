package ch.fhnw.oop2.module08.multilanguage;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MultiLanguageUI extends GridPane {
	private final LanguageSwitcherPM model;

	private Button germanButton;
	private Button englishButton;
	private Label  label;

	public MultiLanguageUI(LanguageSwitcherPM model) {
		this.model = model;
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
		germanButton  = new Button("b1");
		englishButton = new Button("b2");
		label         = new Label("l1");
	}

	private void layoutControls() {
		englishButton.setMaxWidth(Double.MAX_VALUE);
		germanButton.setMaxWidth(Double.MAX_VALUE);

		label.setMaxHeight(Double.MAX_VALUE);
		label.setMaxWidth(Double.MAX_VALUE);

		setPadding(new Insets(10));
		setVgap(20);
		setHgap(20);

		ColumnConstraints grow = new ColumnConstraints();
		grow.setHgrow(Priority.ALWAYS);
		grow.setPercentWidth(50);

		RowConstraints rGrow = new RowConstraints();
		rGrow.setVgrow(Priority.ALWAYS);

		getColumnConstraints().addAll(grow, grow);
		getRowConstraints().add(rGrow);

		add(label, 0, 0, 2, 1);
		addRow(1, germanButton, englishButton);
	}

	private void setupEventHandlers() {
		germanButton.setOnAction(event -> model.setLanguage(LanguageSwitcherPM.Lang.DE));
		englishButton.setOnAction(event -> model.setLanguage(LanguageSwitcherPM.Lang.EN));
	}

	private void setupValueChangedListeners() {
	}

	private void setupBindings() {
		label.textProperty().bind(model.textProperty());
		germanButton.textProperty().bind(model.germanButtonTextProperty());
		englishButton.textProperty().bind(model.englishButtonTextProperty());
	}
}
