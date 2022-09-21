package minesweeper.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HintChanger implements EventHandler<ActionEvent>{

    private final MinesweeperGUI gui;

    public HintChanger(MinesweeperGUI gui){
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent arg0) {
        gui.updateHint();
        
    }
    
}
