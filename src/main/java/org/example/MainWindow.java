package org.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class MainWindow {
    private Originator originator;
    private Caretaker caretaker;
    private HistoryWindow historyWindow;
    private VBox mainLayout = new VBox();

    public MainWindow(Originator originator, Caretaker caretaker, HistoryWindow historyWindow) {
        this.originator = originator;
        this.caretaker = caretaker;
        this.historyWindow = historyWindow;
        setupUI();
    }

    private void setupUI() {
        CheckBox checkbox = new CheckBox("Enable option");
        checkbox.setOnAction(e -> {
            originator.setCheckboxState(checkbox.isSelected());
            caretaker.saveState();
        });

        Button saveButton = new Button("Save State");
        saveButton.setOnAction(e -> caretaker.saveState());

        Button historyButton = new Button("Show History");
        historyButton.setOnAction(e -> historyWindow.show());

        HBox controls = new HBox(10, checkbox, saveButton, historyButton);
        mainLayout.getChildren().add(controls);
    }

    public VBox getMainLayout() {
        return mainLayout;
    }

    public void setupKeyBindings(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case Z -> {
                    if (event.isControlDown()) caretaker.undo();
                }
                case Y -> {
                    if (event.isControlDown()) caretaker.redo();
                }
            }
        });
    }
}
