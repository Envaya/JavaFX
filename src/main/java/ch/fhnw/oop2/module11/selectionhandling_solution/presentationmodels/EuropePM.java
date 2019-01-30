package ch.fhnw.oop2.module11.selectionhandling_solution.presentationmodels;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class EuropePM {
	private final StringProperty  applicationTitle  = new SimpleStringProperty("Selection Handling");
	private final IntegerProperty selectedCountryId = new SimpleIntegerProperty(-1);

	private final ObservableList<CountryPM> allCountries = FXCollections.observableArrayList();

	public EuropePM() {
		allCountries.addAll(getAllCountries());
	}

    public CountryPM getCountry(int id) {
        return allCountries.stream()
                           .filter(countryPM -> countryPM.getId() == id)
                           .findAny()
                           .orElse(null);
    }

	private List<CountryPM> getAllCountries() {
        return List.of(new CountryPM(0, "Schweiz"    ,  41_285.00),
      		           new CountryPM(1, "Deutschland", 357_121.41),
      		           new CountryPM(2, "Frankreich" , 668_763.00),
      		           new CountryPM(3, "Italien"    , 301_338.00),
      		           new CountryPM(4, "Oesterreich",  83_878.99));
	}

	//getter und setter

	public ObservableList<CountryPM> allCountries() {
		return allCountries;
	}

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

	public int getSelectedCountryId() {
		return selectedCountryId.get();
	}

	public IntegerProperty selectedCountryIdProperty() {
		return selectedCountryId;
	}

	public void setSelectedCountryId(int selectedCountryId) {
		this.selectedCountryId.set(selectedCountryId);
	}

}
