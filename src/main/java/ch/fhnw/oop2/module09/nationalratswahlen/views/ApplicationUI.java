package ch.fhnw.oop2.module09.nationalratswahlen.views;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import ch.fhnw.oop2.module09.nationalratswahlen.presentationmodels.Resultat;
import ch.fhnw.oop2.module09.nationalratswahlen.presentationmodels.WahlPM;

public class ApplicationUI extends VBox {
    private final WahlPM model;

    private TableView<Resultat> tabelle;

    public ApplicationUI(WahlPM model) {
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

    public void initializeControls() {
        // hier die Tabelle definieren
        tabelle = new TableView<>(model.getResultate());
        // für TableView müssen Columns definiert werden
        // 1. param: was ist der Quellen Datentyp, 2. param was ist der zu anzeigende Datentyp
        TableColumn<Resultat, String> nameCol = new TableColumn<>("Gemeinde");
        // Achtung, alle Zahlenwerte müssen als Number Typ definiert werden!!!
        TableColumn<Resultat, Number> nmbOfVoters = new TableColumn<>("Wählende");
        TableColumn<Resultat, Number> nmbOfElligibleVoters = new TableColumn<>("Wahlberechtigte");

        //Defin. welche Daten in welcher Column sein sollen:
        nameCol.setCellValueFactory(cell -> cell.getValue().gemeindeNamenProperty());
        nmbOfVoters.setCellValueFactory(cell -> cell.getValue().waehlendeProperty());
        nmbOfElligibleVoters.setCellValueFactory(cell -> cell.getValue().wahlberechtigteProperty());

        //Column der Tabelle zuweisen
        tabelle.getColumns().addAll(nameCol, nmbOfVoters, nmbOfElligibleVoters);
    }

    public void layoutControls() {
        setVgrow(tabelle, Priority.ALWAYS);

        getChildren().addAll(tabelle);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    public void setupBindings() {
    }

}
