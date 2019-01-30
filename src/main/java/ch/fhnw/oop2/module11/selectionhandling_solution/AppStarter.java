package ch.fhnw.oop2.module11.selectionhandling_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.oop2.module11.selectionhandling_solution.presentationmodels.EuropePM;
import ch.fhnw.oop2.module11.selectionhandling_solution.views.ApplicationUI;

public class AppStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		EuropePM model = new EuropePM();

		Parent rootPanel = new ApplicationUI(model);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(model.applicationTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.setResizable(false);

		primaryStage.show();

		model.setSelectedCountryId(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
