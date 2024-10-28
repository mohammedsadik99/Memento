package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Originator originator = new Originator();
        HistoryWindow historyWindow = new HistoryWindow();
        Caretaker caretaker = new Caretaker(originator, historyWindow);

        MainWindow mainWindow = new MainWindow(originator, caretaker, historyWindow);

        Scene scene = new Scene(mainWindow.getMainLayout(), 600, 400);
        mainWindow.setupKeyBindings(scene);

        primaryStage.setTitle("Memento Pattern Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
