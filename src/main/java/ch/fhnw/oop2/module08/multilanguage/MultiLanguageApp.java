package ch.fhnw.oop2.module08.multilanguage;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultiLanguageApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		LanguageSwitcherPM model = new LanguageSwitcherPM();

		Parent rootPanel = new MultiLanguageUI(model);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(model.applicationTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
