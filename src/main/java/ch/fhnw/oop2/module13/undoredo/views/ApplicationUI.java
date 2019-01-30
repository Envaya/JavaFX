package ch.fhnw.oop2.module13.undoredo.views;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import ch.fhnw.oop2.module13.undoredo.presentationmodels.EuropePM;

public class ApplicationUI extends BorderPane implements ViewMixin {
	private final EuropePM model;

	private CountryHeader countryHeader;
	private CountryForm   countryForm;
	private SelectorBar   toolbar;

	public ApplicationUI(EuropePM model) {
		this.model = model;
		init();
	}

    @Override
    public void initializeSelf() {
        addStylesheetFiles("style.css");
    }

    @Override
	public void initializeControls() {
		countryHeader = new CountryHeader(model);
		countryForm = new CountryForm(model);
		toolbar = new SelectorBar(model);
	}

	@Override
	public void layoutControls() {
		setTop(toolbar);
		setCenter(new VBox(countryHeader, countryForm));
	}

}
