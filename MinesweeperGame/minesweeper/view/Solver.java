package minesweeper.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Solver implements EventHandler<ActionEvent>{

    private final MinesweeperGUI gui;

    public Solver(MinesweeperGUI gui){
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent arg0) {
        gui.solveMinesweeper();
        
    }
    
}
