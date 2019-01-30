package ch.fhnw.oop2.module11.stableselection_solution.presentationmodels;

import java.util.Arrays;
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

	private final CountryPM countryProxy = new CountryPM();

	public EuropePM() {
		this(createAllCountries());
	}

	public EuropePM(CountryPM... countries) {
		this(Arrays.asList(countries));
	}

	private EuropePM(List<CountryPM> countryList) {
		allCountries.addAll(countryList);

		selectedCountryIdProperty().addListener((observable, oldValue, newValue) -> {
			                                        CountryPM oldSelection = getCountry(oldValue.intValue());
			                                        CountryPM newSelection = getCountry(newValue.intValue());
			                                        System.out.println(oldValue);

			                                        if (oldSelection != null) {
                                                        unbindFromProxy(oldSelection);
			                                        }

			                                        if (newSelection != null) {
                                                        bindToProxy(newSelection);
			                                        }
		                                        }
		                                       );
	}

    public CountryPM getCountryProxy() {
		return countryProxy;
	}

    private void bindToProxy(CountryPM country) {
        countryProxy.idProperty()  .bindBidirectional(country.idProperty());
        countryProxy.nameProperty().bindBidirectional(country.nameProperty());
        countryProxy.areaProperty().bindBidirectional(country.areaProperty());
    }

    private void unbindFromProxy(CountryPM country) {
        countryProxy.idProperty()  .unbindBidirectional(country.idProperty());
        countryProxy.nameProperty().unbindBidirectional(country.nameProperty());
        countryProxy.areaProperty().unbindBidirectional(country.areaProperty());
    }

    private CountryPM getCountry(int id) {
        return allCountries.stream()
                           .filter(countryPM -> countryPM.getId() == id)
                           .findAny()
                           .orElse(null);
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
