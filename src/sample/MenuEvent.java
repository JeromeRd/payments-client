package sample;

import javafx.event.Event;

public class MenuEvent {
    enum TypeMenuEvent {
        CREATE_USER, CLEAN_OUTPUT, TEST;
    }

    private TypeMenuEvent typeMenuEvent;

    public MenuEvent(TypeMenuEvent typeMenuEvent) {
        this.typeMenuEvent = typeMenuEvent;
    }

    public TypeMenuEvent getTypeMenuEvent() {
        return typeMenuEvent;
    }
}
