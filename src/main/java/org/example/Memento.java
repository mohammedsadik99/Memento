package org.example;


import java.time.LocalDateTime;

public class Memento {
    private String colorState;
    private boolean checkboxState;
    private LocalDateTime timestamp;

    public Memento(String colorState, boolean checkboxState) {
        this.colorState = colorState;
        this.checkboxState = checkboxState;
        this.timestamp = LocalDateTime.now();
    }

    public String getColorState() {
        return colorState;
    }

    public boolean getCheckboxState() {
        return checkboxState;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "State saved at: " + timestamp;
    }
}
