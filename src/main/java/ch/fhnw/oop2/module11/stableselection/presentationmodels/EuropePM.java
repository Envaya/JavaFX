package ch.fhnw.oop2.module11.stableselection.presentationmodels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.fhnw.oop2.module04.countries.Country;
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
		this(createAllCountries());
	}

	public EuropePM(CountryPM... countries) {
		this(new ArrayList<>(Arrays.asList(countries)));
	}

	private EuropePM(List<CountryPM> countryList) {
		allCountries.addAll(countryList);
		selectedCountryId.addListener((observable, oldValue, newValue) -> {
			CountryPM oldCountry = getCountry(oldValue.intValue());
			CountryPM newCountry = getCountry(newValue.intValue());

			if ( oldCountry != null) {
				proxy.idProperty().unbindBidirectional(oldCountry.idProperty());
				proxy.nameProperty().unbindBidirectional(oldCountry.idProperty());
				proxy.areaProperty().unbindBidirectional(oldCountry.areaProperty());
			}
			if ( newCountry != null) {
				proxy.idProperty().bindBidirectional(newCountry.idProperty());
				proxy.nameProperty().bindBidirectional(newCountry.nameProperty());
				proxy.areaProperty().bindBidirectional(newCountry.areaProperty());
			}
		});
	}

	private final CountryPM proxy = new CountryPM();

	public CountryPM getCountryProxy() {
		return proxy;
	}

    private CountryPM getCountry(int id) {
        return allCountries.stream()
                           .filter(countryPM -> countryPM.getId() == id)
                           .findAny().orElse(null);
    }

	private static List<CountryPM> createAllCountries() {
        return List.of(new CountryPM(0, "Schweiz"    , 41_285.00),
      		           new CountryPM(1, "Deutschland", 357_121.41),
      		           new CountryPM(2, "Frankreich" , 668_763.00),
      		           new CountryPM(3, "Italien"    , 301_338.00),
      		           new CountryPM(4, "Oesterreich",  83_878.99));
	}

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
