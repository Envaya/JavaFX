package ch.fhnw.oop2.module09.nationalratswahlen_solution.presentationmodels;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * @author Dieter Holz
 */
public class WahlPM {
	private static final String FILE_NAME = "Nationalratswahlen2007.txt";

	private static final String DELIMITER = "\t";

	private final StringProperty applicationTitle = new SimpleStringProperty("Nationalratswahlen 2007");

	private final ObservableList<Resultat> resulate = FXCollections.observableArrayList();

	public WahlPM() {
		resulate.addAll(readFromFile());
	}


    private List<Resultat> readFromFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME)) {
            return stream.skip(1)                                              // erste Zeile ist die Headerzeile; ueberspringen
                         .map(line -> new Resultat(line.split(DELIMITER, 22))) // aus jeder Zeile ein Objekt machen
                         .collect(Collectors.toList());                        // alles aufsammeln
        }
    }

	public void save() {
		try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME))) {
			writer.write("Gemeinde-Nr.\tBFS Gemeinden\tKanton\tFDP\tCVP\tSPS\tSVP\tLPS\tEVP\tCSP\tGLP\tPdA Sol.\tFGA\tGPS\tSD\tEDU\tFPS\tLega\tÜbrige\tWahlberechtigte\tWählende");
			writer.newLine();
			resulate.stream()
                    .map(resultat -> resultat.infoAsLine(DELIMITER))
                    .forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    });
		} catch (IOException e) {
			throw new IllegalStateException("save failed");
		}
	}


	private Stream<String> getStreamOfLines(String fileName) {
		try {
			return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private Path getPath(String fileName)  {
		try {
			return Paths.get(getClass().getResource(fileName).toURI());
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}


	// all getters and setters

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public ObservableList<Resultat> getResulate() {
		return resulate;
	}

}
