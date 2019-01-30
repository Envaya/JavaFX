package ch.fhnw.oop2.module09.simplelistview;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class PresentationModel {
	private final StringProperty applicationTitle = new SimpleStringProperty("A very simple list");

	// darf final sein weil nur Referenz, (kein primitver Datentyp)
	private final ObservableList<String> allElements = FXCollections.observableArrayList();

	public ObservableList<String> getAllElements() {
		return allElements;
	}

	public void addNewElement() {
		allElements.add("neu -" + allElements.size());
	}
	// all getters and setters

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

}
