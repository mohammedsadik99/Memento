package org.example;

public class Originator {
    private String colorState;
    private boolean checkboxState;

    public Memento createMemento() {
        return new Memento(colorState, checkboxState);
    }

    public void restore(Memento memento) {
        this.colorState = memento.getColorState();
        this.checkboxState = memento.getCheckboxState();
    }

    public void setColorState(String colorState) {
        this.colorState = colorState;
    }

    public String getColorState() {
        return colorState;
    }

    public void setCheckboxState(boolean checkboxState) {
        this.checkboxState = checkboxState;
    }

    public boolean getCheckboxState() {
        return checkboxState;
    }
}
