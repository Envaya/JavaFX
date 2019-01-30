package ch.fhnw.oop2.module07.eventhandling;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventHandlingApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new EventHandlingExample();

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("JavaFX App");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
