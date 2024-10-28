package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryWindow {
    private ObservableList<Memento> historyList = FXCollections.observableArrayList();

    public void show() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        ListView<Memento> listView = new ListView<>(historyList);
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Memento selectedMemento = listView.getSelectionModel().getSelectedItem();
                if (selectedMemento != null) {
                    // Restore selected state
                    // Handle in Caretaker or another class if necessary
                }
            }
        });

        VBox layout = new VBox(listView);
        Scene scene = new Scene(layout, 300, 400);
        historyStage.setScene(scene);
        historyStage.show();
    }

    public void addMemento(Memento memento) {
        historyList.add(memento);
    }
}
