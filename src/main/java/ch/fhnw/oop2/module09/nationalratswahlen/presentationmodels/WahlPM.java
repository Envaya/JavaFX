package ch.fhnw.oop2.module09.nationalratswahlen.presentationmodels;

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

    private final ObservableList<Resultat> resultate = FXCollections.observableArrayList();

    public WahlPM() {
        resultate.addAll(readFromFile());
    }

    private List<Resultat> readFromFile() {
        // zuerst Stream erstellen
        try(Stream<String> stream = getStreamOfLines(FILE_NAME)) {
            // Jede Line ist ein String
            return stream.skip(1)
                    // wir teilen den String einer Line in die einzelnen Spalten auf und erstellen mit diesen Daten ein Resultat Objekt
                    .map(line -> new Resultat(line.split(DELIMITER, 22)))
                    .collect(Collectors.toList());
        }
    }

    public void save() {
        //todo implement
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

    public ObservableList<Resultat> getResultate() {
        return resultate;
    }
}