package org.example;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();
    private Originator originator;
    private HistoryWindow historyWindow;

    public Caretaker(Originator originator, HistoryWindow historyWindow) {
        this.originator = originator;
        this.historyWindow = historyWindow;
    }

    public void saveState() {
        Memento memento = originator.createMemento();
        undoStack.push(memento);
        redoStack.clear(); // Clear redo stack when a new state is saved
        historyWindow.addMemento(memento);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(originator.createMemento());
            originator.restore(undoStack.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(originator.createMemento());
            originator.restore(redoStack.pop());
        }
    }

    public void restoreToState(Memento memento) {
        originator.restore(memento);
        undoStack.push(memento);
        redoStack.clear();
    }
}
