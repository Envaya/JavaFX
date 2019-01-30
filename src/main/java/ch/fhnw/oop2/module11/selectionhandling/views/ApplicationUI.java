package ch.fhnw.oop2.module11.selectionhandling.views;

import javafx.scene.layout.BorderPane;

import ch.fhnw.oop2.module11.selectionhandling.presentationmodels.EuropePM;

public class ApplicationUI extends BorderPane implements ViewMixin {
	private final EuropePM model;

	private CountryForm countryForm;
	private SelectorBar toolbar;

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
		countryForm = new CountryForm(model);
		toolbar     = new SelectorBar(model);
	}

	@Override
	public void layoutControls() {
		setTop(toolbar);
		setCenter(countryForm);
	}

}
