package ch.fhnw.oop2.module09.colormemory;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColorMemoryUI extends VBox {
	private final CoolColorMemoryPM model;

	private ColorMixerPane  colorMixer;
	private Button          isCoolButton;
	private ListView<Color> listView;

	public ColorMemoryUI(CoolColorMemoryPM model) {
		this.model = model;
        initializeSelf();
        initializeControls();
		layoutControls();
		setupEventHandlers();
		setupValueChangedListeners();
		setupBindings();
	}

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        colorMixer   = new ColorMixerPane(model);
        isCoolButton = new Button("This is cool");
        listView     = new ListView<>();
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setSpacing(10);

		isCoolButton.setMaxWidth(Double.MAX_VALUE);
		setVgrow(listView, Priority.ALWAYS);

		getChildren().addAll(colorMixer, isCoolButton, listView);
	}

	private void setupEventHandlers() {
	}

	private void setupValueChangedListeners() {
	}

	private void setupBindings() {
	}
}
