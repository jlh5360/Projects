package minesweeper.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Resetter implements EventHandler<ActionEvent> {

    private final MinesweeperGUI gui;

    public Resetter(MinesweeperGUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.resetGame();
    }
    
}
