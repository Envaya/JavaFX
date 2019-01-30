package ch.fhnw.oop2.module13.undoredo;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.oop2.module13.undoredo.presentationmodels.EuropePM;
import ch.fhnw.oop2.module13.undoredo.views.ApplicationUI;

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
