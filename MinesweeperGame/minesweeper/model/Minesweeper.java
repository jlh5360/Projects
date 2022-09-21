package minesweeper.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Minesweeper {
    public final char MINE = 'M';
    public final char COVERED = '-';
    private final Location[][] gameBoard;
    private int moveCount;
    private GameState gameState;
    private final int rows;
    private final int cols;
    private final int mineCount;
    private MinesweeperObserver observer;

    /* Attributes:
        Each cell will be represented by a Cell class, initialized by location
        We'll represent the game board by a Location->Cell map

        Game board will be initialized like this:
        Create a list/array of Cells of size rows*cols
        Set the first mineCount Cells as mines
        Shuffle the list/array
        For each row/col location, put into map Location -> corresponding index in list/array 
        Gameboard = map

    */

    //See Discord group chat

    /**
     * Normal constructor for a new minesweeper game based on the number of rows, columns, and mines in the gameboard.
     * 
     * @param rows The number of rows.
     * @param cols The number of columns.
     * @param mineCount The number of mines.
     */
    public Minesweeper(int rows, int cols, int mineCount) {
        this.moveCount = 0;
        this.gameState = GameState.NOT_STARTED;
        this.rows = rows;
        this.cols = cols;
        this.gameBoard = new Location[rows][cols];
        this.mineCount = mineCount;
        startGame();
    }

    public int getRows(){
        return this.rows;
    }
    public int getCols(){
        return this.cols;
    }

    /**
     * Copy constructor that creates a deep copy of an existing game.
     * 
     * @param minesweeper The minesweeper game being copied.
     */
    public Minesweeper(Minesweeper minesweeper) {
        this.moveCount = minesweeper.moveCount;
        this.gameState = minesweeper.gameState;
        this.rows = minesweeper.rows;
        this.cols = minesweeper.cols;
        this.gameBoard = new Location[minesweeper.rows][minesweeper.cols];
        for(int r=0; r<minesweeper.rows; r++) {
            for(int c=0; c<minesweeper.cols; c++) {
                Location location = minesweeper.gameBoard[r][c];
                this.gameBoard[r][c] = new Location(r, c, location.getCurrentView());
                if(location.isMine()) {
                    this.gameBoard[r][c].setAsMine();
                } else {
                    this.gameBoard[r][c].setValue(location.getValue());
                }
                if(!location.isCovered()) {
                    this.gameBoard[r][c].uncover();
                }
            }
        }
        this.mineCount = minesweeper.mineCount;
    }

    public void register(MinesweeperObserver observer) {
        this.observer = observer;
    }

    private void notifyObserver(Location location) {
        if(this.observer != null) {
            observer.cellUpdated(location);
        }
    }

    public char getSymbol(Location location) throws MinesweeperException {
        Location boardLocation = gameBoard[location.getRow()][location.getCol()];
        if(boardLocation.isCovered()) {
            return COVERED;
        } else {
            return boardLocation.getValue();
        }
    }

    public int getMineCount(){
        return mineCount;
    }

    public boolean isCovered(Location location) throws MinesweeperException {
        try {
            Location boardLocation = gameBoard[location.getRow()][location.getCol()];
            return boardLocation.isCovered();
            } catch(IndexOutOfBoundsException e) {
                throw new MinesweeperException("Square is outside the board.");
            }
    }

    // After choosing a location it will uncover the location, get the value of the location and determines the gameStatus
    //   - If the entered location's row and col values are BOTH >= 0 && <= this.rows/this.cols
    //      - If the location value matches to this.MINE, then the game is over
    //      - Else if the location value does not match to this.MINE && if the size of the board minus
    //        the number of mines (essentially being all the correct locations that are not mines)
    //        equals to the number of move counts, then you have won the game
    //      - Otherwise, then the game is in progress
    //   - Otherwise (if the user's entered location is not withing the range | if the entered location's row and col values are EITHER/BOTH NOT >= 0 AND OR NOT <= this.rows/this.cols)
    //      - Then it throws the MinesweeperException

    public void makeSelection(Location location) throws MinesweeperException {
        int row = location.getRow();
        int col = location.getCol();

        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new MinesweeperException("Invalid Move (location is outside the board)");
        } else if(!this.gameBoard[row][col].isCovered()) {
            throw new MinesweeperException("Invalid Move (can't uncover an already-revealed cell)");
        } 

        if(this.gameState == GameState.NOT_STARTED) {
            while(this.gameBoard[row][col].isMine()) {
                startGame();
            }
            this.gameState = GameState.IN_PROGRESS;
        }
        
        this.gameBoard[row][col].uncover();
        this.moveCount++;
        
        if (this.gameBoard[row][col].isMine()) {
            this.gameState = GameState.LOST;
            this.gameOver();
        }
        else if ((!this.gameBoard[row][col].isMine()) && ((this.rows*this.cols - this.mineCount) == this.moveCount)) {
            this.gameState = GameState.WON;
            this.gameOver();
        }

        notifyObserver(location);
        
    }

    // What I added for "Beyond The Project"
    // ==========================================================================================================================
    public void flag(Location location) throws MinesweeperException {
        int row = location.getRow();
        int col = location.getCol();

        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new MinesweeperException("Invalid Move (location is outside the board)");
        } else if(!this.gameBoard[row][col].isCovered()) {
            throw new MinesweeperException("Invalid Move (can't uncover an already-revealed cell)");
        }

        if (this.gameState == GameState.NOT_STARTED) {
            this.gameState = GameState.IN_PROGRESS;
        }
        
        if (this.gameBoard[row][col].isCovered()) {            
            // if the location is NOT flagged, set the location to be flagged
            if (this.gameBoard[row][col].isFlagged() == false) {
                this.gameBoard[row][col].setAsFlag();
            }
            // otherwise (if it IS flagged), set the location to NOT be flagged
            // BUT the location is NOT UNCOVERED (SHOULD still be COVERED)
            else if (this.gameBoard[row][col].isFlagged() == true) {
                this.gameBoard[row][col].removeFlag();
            }
        }

        notifyObserver(location);
    }
    // ==========================================================================================================================

    /**
     * Initializes the game by doing the following:
     * - Adding a new location for each row/col spot to a list with the COVERED character
     * - shuffling said list to randomize the positions
     * - using Location.setAsMine() to set the first this.mineCount locations in the shuffled list as mines
     * - Adding each location to the correct spot in this.gameBoard using the Location getters
     * - Setting the value of each non-mine location to the number of mines adjacent to it
     */
    private void startGame() {
        List<Location> locations = new ArrayList<>();
        for(int row=0; row<this.rows; row++) {
            for(int col=0; col<this.cols; col++) {
                locations.add(new Location(row, col, COVERED));
            }
        }

        
        Collections.shuffle(locations);
        for(int m=0; m<this.mineCount; m++) {
            locations.get(m).setAsMine();
        }
        for(Location location : locations) {
            this.gameBoard[location.getRow()][location.getCol()] = location;
        }

        for (int r = 0; r < rows; r = (r + 1)) {
            for (int c = 0; c < cols; c = (c + 1)) {
                if (!gameBoard[r][c].isMine()) {
                    int int_value = 0;

                    if ((r >= 0) && (r < rows) && (c >= 0) && (c < cols)) {
                        if ((r - 1 >= 0) && (c - 1 >= 0)) {
                            if (this.gameBoard[r - 1][c - 1].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if (r - 1 >= 0) {
                            if (this.gameBoard[r - 1][c].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if ((r - 1 >= 0) && (c + 1 < cols)) {
                            if (this.gameBoard[r - 1][c + 1].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if (c - 1 >= 0) {
                            if (this.gameBoard[r][c - 1].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if (c + 1 < cols) {
                            if (this.gameBoard[r][c + 1].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if ((r + 1 < rows) && (c - 1 >= 0)) {
                            if (this.gameBoard[r + 1][c - 1].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if (r + 1 < rows) {
                            if (this.gameBoard[r + 1][c].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                        if ((r + 1 < rows) && (c + 1 < cols)) {
                            if (this.gameBoard[r + 1][c + 1].getValue() == this.MINE) {
                                int_value = (int_value + 1);
                            }
                        }
                    }

                    char char_value = (char)(int_value + 48);
                    this.gameBoard[r][c].setValue(char_value);
                }

            }
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void setGameState(GameState newGameState){
        this.gameState = newGameState;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Collection<Location> getPossibleSelections() {
        List<Location> list = new ArrayList<>();
        for(int row=0; row<this.rows; row++) {
            for(int col=0; col<this.cols; col++) {
                if(this.gameBoard[row][col].isCovered()) {
                    if(!this.gameBoard[row][col].isMine()){
                        list.add(this.gameBoard[row][col]);
                    }
                }
            }
        }
        Collections.shuffle(list);
        return list;
    }

    public void gameOver() {
        if(this.gameState == GameState.LOST || this.gameState == GameState.WON) {
            for(Location[] locations : this.gameBoard) {
                for(Location location : locations) {
                    if(location.isCovered()) {
                        location.uncover();
                        notifyObserver(location);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        
        for (int r = 0; r < this.rows; r = (r + 1)) {
            String board = "";
            for (int c = 0; c < this.cols; c = (c + 1)) {
                board = (board + this.gameBoard[r][c]);
            }
            result = (result + board + "\n");
        }

        return result;
    }
}
