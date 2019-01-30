package ch.fhnw.oop2.module07.unidirectionalbinding;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UniDirectionalBindingApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new UnidirectionalBindingExample();

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("Unidirectional Binding");
		primaryStage.setScene(scene);

		primaryStage.setResizable(false);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
