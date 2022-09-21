package minesweeper.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import backtracker.Backtracker;
import backtracker.Configuration;

public class MinesweeperSolver implements Configuration{

    private Minesweeper minesweeper;
    private int lastCol;
    private int lastRow;
    private Location[] selections;

    public MinesweeperSolver(Minesweeper minesweeper){
        this.minesweeper = minesweeper;
        this.lastRow = -1;
        this.lastCol = -1;
        this.selections = new Location[0];
    }

    public MinesweeperSolver(int row, int col, Minesweeper minesweeper, Location[] locations){
        this.minesweeper = minesweeper;
        this.lastCol = col;
        this.lastRow = row;
        this.selections = locations;
    }

    public Location[] getSelections() {
        return this.selections;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();
        for(int r = 0; r < minesweeper.getRows(); r++){
            for(int c = 0; c < minesweeper.getCols(); c ++){
                Location[] locations = Arrays.copyOf(this.selections, this.selections.length + 1);
                locations[locations.length - 1] = new Location(r, c, '-');
                Configuration next = new MinesweeperSolver(r, c, new Minesweeper(minesweeper), locations);
                successors.add(next);
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        try{
        minesweeper.makeSelection(new minesweeper.model.Location(lastRow, lastCol, '-'));
        } catch (MinesweeperException e){
            return false;
        }
        return (minesweeper.getGameState() != GameState.LOST);
    }

    @Override
    public boolean isGoal() {
        return minesweeper.getGameState() == GameState.WON;
    }

    public static Configuration createSolver(Minesweeper minesweeper) {
        Configuration start = new MinesweeperSolver(new Minesweeper(minesweeper));
        Backtracker solver = new Backtracker(false);
        Configuration solution = solver.solve(start);
        return solution;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        
        for (Location location : this.selections) {
            String string = ("(" + location.getRow() + ", " + location.getCol() + ")");
            result.append(string);
            result.append(", ");
        }

        if (this.selections.length > 0) {
            result.append("\b\b");
        }

        result.append("]\n");
        result.append(this.minesweeper.toString());

        return result.toString();
    }
}
