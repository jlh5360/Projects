package minesweeper.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import minesweeper.model.Location;

public class SquareObserver implements EventHandler<ActionEvent> {

    private final Location location;
    private final MinesweeperGUI gui;

    public SquareObserver(Location location, MinesweeperGUI gui) {
        this.location = location;
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.makeMove(location);
    }
    
}
