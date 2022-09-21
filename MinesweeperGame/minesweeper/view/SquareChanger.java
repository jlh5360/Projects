package minesweeper.view;

import minesweeper.model.Location;
import minesweeper.model.MinesweeperObserver;

public class SquareChanger implements MinesweeperObserver {

    public MinesweeperGUI gui;

    public SquareChanger(MinesweeperGUI gui) {
        this.gui = gui;
    }

    @Override
    public void cellUpdated(Location location) {
        gui.updateButton(location);
    }
    
}
