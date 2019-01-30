package ch.fhnw.oop2.module06.applicationtemplate;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationStarter extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent rootPane = new ApplicationUI();

        Scene myScene = new Scene(rootPane);

        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(myScene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.show();
    };

    public static void main(String[] args) {
        launch(args);
    }
}
